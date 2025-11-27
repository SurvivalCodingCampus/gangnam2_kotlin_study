package com.hhp227.kotlinstudy.`17_result`

import com.hhp227.kotlinstudy.`17_result`.datasource.UserDataSourceImpl
import com.hhp227.kotlinstudy.`17_result`.repository.UserRepository
import com.hhp227.kotlinstudy.`17_result`.repository.UserRepositoryImpl
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test
import java.io.IOException
import java.net.SocketTimeoutException
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserRepositoryTest {
    lateinit var userRepository: UserRepository

    private fun createMockClient(handler: MockRequestHandler): HttpClient =
        HttpClient(MockEngine { request -> handler(request) }) {
            expectSuccess = false

            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
        }

    @Test
    fun `getUserById() 메소드로 하나의 유저 가져오기 테스트`() = runTest {
        val user = User(1, "홍길동")
        val client = createMockClient { _ ->
            respond(
                content = Json.encodeToString(user),
                status = HttpStatusCode.OK,
                headers = headersOf("Content-Type", "application/json")
            )
        }
        val dataSource = UserDataSourceImpl(client)
        userRepository = UserRepositoryImpl(dataSource)
        val result = userRepository.getUserById(1)

        assertTrue(result is Result.Success<*>)
        assertEquals(user, (result as Result.Success<*>).data)
    }

    @Test
    fun `getUserById() 메소드로 유저를 찾을수 없을때`() = runTest {
        val client = createMockClient { _ ->
            respond(
                content = "",
                status = HttpStatusCode.NotFound
            )
        }
        val dataSource = UserDataSourceImpl(client)
        userRepository = UserRepositoryImpl(dataSource)
        val result = userRepository.getUserById(999)

        assertTrue(result is Result.Error<*>)
        val error = (result as Result.Error<*>).error
        assertTrue(error is NetworkError.Unknown)
    }

    @Test
    fun `모든 유저 가져오기 테스트`() = runTest {
        val users = listOf(User(1, "홍길동"), User(2, "한석봉"))
        val client = createMockClient { _ ->
            respond(
                Json.encodeToString(users),
                HttpStatusCode.OK,
                headersOf("Content-Type", "application/json")
            )
        }
        val dataSource = UserDataSourceImpl(client)
        userRepository = UserRepositoryImpl(dataSource)
        val result = userRepository.getAllUsers()

        assertTrue(result is Result.Success)
        assertEquals(users, result.data)
    }

    @Test
    fun `타임 아웃이 나는지 테스트`() = runTest {
        val client = createMockClient { _ ->
            throw SocketTimeoutException("Timeout!")
        }
        val dataSource = UserDataSourceImpl(client)
        userRepository = UserRepositoryImpl(dataSource)
        val result = userRepository.getUserById(1)

        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.Timeout)
    }

    @Test
    fun `네트워크 에러가 발생하는지 테스트`() = runTest {
        val client = createMockClient { _ ->
            throw IOException("IO 에러")
        }
        val dataSource = UserDataSourceImpl(client)
        userRepository = UserRepositoryImpl(dataSource)
        val result = userRepository.getUserById(1)

        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.NetworkUnavailable)
    }

    @Test
    fun `나머지 예외처리는 Unknown으로 처리되는지 테스트`() = runTest {
        val client = createMockClient { _ ->
            throw IllegalStateException("잘못된 전송")
        }
        val dataSource = UserDataSourceImpl(client)
        userRepository = UserRepositoryImpl(dataSource)
        val result = userRepository.getUserById(1)

        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.Unknown)
    }
}
