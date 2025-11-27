package com.survivalcoding.kotlinstudy.`18_result`.repository

import com.survivalcoding.kotlinstudy.`18_result`.core.NetworkError
import com.survivalcoding.kotlinstudy.`18_result`.core.Response
import com.survivalcoding.kotlinstudy.`18_result`.core.Result
import com.survivalcoding.kotlinstudy.`18_result`.data_source.UserDataSource
import com.survivalcoding.kotlinstudy.`18_result`.data_source.UserDataSourceImpl
import com.survivalcoding.kotlinstudy.`18_result`.dto.UserDto
import com.survivalcoding.kotlinstudy.`18_result`.dto.UserRequestDto
import com.survivalcoding.kotlinstudy.`18_result`.mock.TestHttpClientFactory
import com.survivalcoding.kotlinstudy.`18_result`.mock.UserDataSourceMockEngine
import com.survivalcoding.kotlinstudy.`18_result`.model.User
import io.ktor.client.engine.mock.*
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.SerializationException
import java.net.UnknownHostException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserRepositoryImplTest {
    private val dataSource: UserDataSource = mockk()
    private val repository = UserRepositoryImpl(dataSource)

    // GET /users/{id}
    @Test
    fun `GET user 성공`() = runTest {
        coEvery { dataSource.getUser(1) } returns
                Response(200, emptyMap(), UserDto(id = 1, name = "Test User"))

        val result = repository.getUser(1)

        assertTrue(result is Result.Success)
        assertEquals("Test User", (result as Result.Success).data.name)
    }

    @Test
    fun `GET user 실패 - 응답 본문 NULL`() = runTest {
        coEvery { dataSource.getUser(10) } returns
                Response(200, emptyMap(), null)

        val result = repository.getUser(10)

        assertTrue(result is Result.Error)
        assertEquals(NetworkError.ParseError, (result as Result.Error).error)
    }

    @Test
    fun `GET user 실패 - HTTP 404`() = runTest {
        coEvery { dataSource.getUser(1) } returns
                Response(404, emptyMap(), null)

        val result = repository.getUser(1)

        assertTrue(result is Result.Error)
        assertEquals(NetworkError.HttpError(404), (result as Result.Error).error)
    }

    @Test
    fun `GET user 실패 - Timeout`() = runTest {
        val delayMillis = 100L
        val timeoutMillis = 1L

        // MockEngine: 지연응답 준비
        val engine: MockEngine = UserDataSourceMockEngine.respondAfterDelay(delayMillis)

        // HttpClient: 1ms 타임아웃이 설정된 클라이언트를 생성
        val client = TestHttpClientFactory.createWithTimeout(engine, timeoutMillis)

        val dataSource = UserDataSourceImpl(client)
        val repository = UserRepositoryImpl(dataSource)

        val result = repository.getUser(1)

        assertTrue(result is Result.Error)
        assertTrue((result as Result.Error).error is NetworkError.Timeout)
    }

    @Test
    fun `GET user 실패 - NetworkUnavailable`() = runTest {
        coEvery { dataSource.getUser(any()) } throws UnknownHostException()

        val result = repository.getUser(1)

        assertTrue(result is Result.Error)
        assertEquals(NetworkError.NetworkUnavailable, (result as Result.Error).error)
    }

    @Test
    fun `GET user 실패 - JSON Parse Error`() = runTest {
        coEvery { dataSource.getUser(any()) } throws SerializationException("Parse error")

        val result = repository.getUser(1)

        assertTrue(result is Result.Error)
        assertEquals(NetworkError.ParseError, (result as Result.Error).error)
    }

    @Test
    fun `GET user 실패 - Unknown`() = runTest {
        coEvery { dataSource.getUser(any()) } throws Exception("Unexpected error")

        val result = repository.getUser(1)

        assertTrue(result is Result.Error)
        assertEquals(NetworkError.Unknown("Unexpected error"), (result as Result.Error).error)
    }


    // GET /users 테스트
    @Test
    fun `GET users 성공`() = runTest {
        coEvery { dataSource.getUsers() } returns Response(
            200,
            emptyMap(),
            listOf(UserDto(id = 1, name = "User1"))
        )

        val result = repository.getUsers()

        assertTrue(result is Result.Success)
        assertEquals(1, (result as Result.Success).data.size)
    }

    @Test
    fun `GET users 실패 - HTTP 500`() = runTest {
        coEvery { dataSource.getUsers() } returns Response(
            500,
            emptyMap(),
            null
        )

        val result = repository.getUsers()

        assertTrue(result is Result.Error)
        val error = (result as Result.Error).error
        assertTrue(error is NetworkError.HttpError)
        assertEquals(500, (error as NetworkError.HttpError).code)
    }


    // POST /users 테스트
    @Test
    fun `POST user 성공`() = runTest {
        val newUser = User(name = "New", username = "new", email = "new@test.com")

        coEvery {
            dataSource.createUser(any<UserRequestDto>())
        } returns Response(201, emptyMap(), 11)

        val result = repository.createUser(newUser)

        assertTrue(result is Result.Success)
        assertEquals(11, (result as Result.Success).data)
    }

    @Test
    fun `POST user 실패 - HTTP 400`() = runTest {
        coEvery {
            dataSource.createUser(any<UserRequestDto>())
        } returns Response(400, emptyMap(), null)

        val result = repository.createUser(User())

        assertTrue(result is Result.Error)
        assertEquals(NetworkError.HttpError(400), (result as Result.Error).error)
    }
}
