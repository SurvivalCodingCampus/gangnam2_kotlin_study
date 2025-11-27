package com.luca.kotlinstudy._18_result.repository

import com.luca.kotlinstudy._18_result.datasource.UserDataSource
import com.luca.kotlinstudy._18_result.dto.UserDTO
import com.luca.kotlinstudy._18_result.mapper.toUser
import com.luca.kotlinstudy.core.Result
import com.luca.kotlinstudy.core.Response
import com.luca.kotlinstudy.core.NetworkError
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest {

    @MockK
    lateinit var dataSource: UserDataSource

    @InjectMockKs
    lateinit var repository: UserRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }
    @Test
    fun `findAll - 성공 시 user 리스트를 반환`() = runTest {
        coEvery { dataSource.findAll() } returns Response(
            statusCode = 200,
            headers = emptyMap(),
            body = listOf(
                UserDTO(id = 1, name = "AA", username = "aa", phone = "0000"),
                UserDTO(id = 2, name = "BB", username = "bb", phone = "1111")
            )
        )

        val result = repository.findAll()

        result as Result.Success
        assertEquals(2, result.data.size)
        assertEquals("AA", result.data.first().name)
    }

    @Test
    fun `create - 성공 시 생성된 user를 반환한다`() = runTest {
        // given
        val userDTO = UserDTO(
            id = 1,
            name = "AA",
            username = "aa",
            phone = "0000"
        )

        coEvery { dataSource.create(any()) } returns Response(
            statusCode = 201,
            headers = emptyMap(),
            body = userDTO
        )

        // when
        val user = userDTO.toUser()
        val result = repository.create(user)

        // then
        result as Result.Success
        assertEquals(1, result.data.userId)
        assertEquals("AA", result.data.name)
    }


    @Test
    fun `findAll - 404 응답 시 HttpError를 반환`() = runTest {

        coEvery { dataSource.findAll() } returns
                Response(
                    statusCode = 404,
                    headers = emptyMap(),
                    body = null
                )

        val result = repository.findAll()

        // 결과가 Failure 타입인지 확인
        assertTrue(result is Result.Failure)

        // Failure 객체에서 error를 추출하여 NetworkError 타입인지 확인
        val err = (result as Result.Failure).error
        assertTrue(err is NetworkError.HttpError)

        // HttpError 객체의 code가 404인지 최종 확인
        assertEquals(404, (err as NetworkError.HttpError).code)
    }

    @Test
    fun `findAll - 타임아웃 발생 시 Timeout 에러를 반환`() = runTest {
        coEvery { dataSource.findAll() } throws HttpRequestTimeoutException("타임아웃", 10000L)

        val result = repository.findAll()

        assertTrue(result is Result.Failure)
        // 에러 타입이 NetworkError.Timeout인지 확인
        val error = (result as Result.Failure).error
        assertTrue(error is NetworkError.Timeout)
    }

    @Test
    fun `findAll - JSON 파싱 실패 시 ParseError를 반환`() = runTest {
        coEvery { dataSource.findAll() } returns
                Response(
                    statusCode = 200,
                    headers = emptyMap(),
                    body = null
                )

        val result = repository.findAll()

        assertTrue(result is Result.Failure)
        val error = (result as Result.Failure).error
        assertTrue(error is NetworkError.ParseError)
    }

    @Test
    fun `findAll - 예상치 못한 예외 발생 시 Unknown 에러를 반환`() = runTest {
        coEvery { dataSource.findAll() } throws IllegalStateException("Unknown error")

        val result = repository.findAll()

        assertTrue(result is Result.Failure)
        val error = (result as Result.Failure).error
        assertTrue(error is NetworkError.Unknown)
    }

    @Test
    fun `findAll - 네트워크 장애 시 NetworkUnavailable를 반환`() = runTest {
        coEvery { dataSource.findAll() } throws java.io.IOException("network down")

        val result = repository.findAll()

        assertTrue(result is Result.Failure)
        val error = (result as Result.Failure).error
        assertTrue(error is NetworkError.NetworkUnavailable)
    }

}
