package com.luca.kotlinstudy._18_result.repository

import com.luca.kotlinstudy._18_result.datasource.UserDataSource
import com.luca.kotlinstudy._18_result.dto.UserDTO
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
    fun `유효한 user 리스트를 반환`() = runTest {

        // given
        coEvery { dataSource.findAll() } returns
                Response(
                    statusCode = 200,
                    headers = emptyMap(),
                    body = listOf(
                        UserDTO(
                            id = 1,
                            name = "AA",
                            username = "aa",
                            phone = "0000",
                        ),
                        UserDTO(
                            id = 2,
                            name = "BB",
                            username = "bb",
                            phone = "1111",
                        ),
                    )
                )

        // when
        val result = repository.findAll()

        // then
        when (result) {
            is Result.Success -> {
                assertEquals(2, result.data.size)
                assertEquals("AA", result.data.first().name)
            }

            is Result.Failure -> fail("Success 기대했는데 Failure가 나옴: ${result.error}")
        }
    }

    @Test
    fun `404일 경우 HttpError`() = runTest {

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
    fun `타임아웃 발생 시 Failure 반환`() = runTest {
        coEvery { dataSource.findAll() } throws HttpRequestTimeoutException("타임아웃", 10000L)

        val result = repository.findAll()

        assertTrue(result is Result.Failure)
        // 에러 타입이 NetworkError.Timeout인지 확인
        val error = (result as Result.Failure).error
        assertTrue(error is NetworkError.Timeout)
    }

    @Test
    fun `JSON 파싱 실패 시 ParseError`() = runTest {
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
    fun `알 수 없는 예외 발생 시 Unknown 오류`() = runTest {
        coEvery { dataSource.findAll() } throws IllegalStateException("Unknown error")

        val result = repository.findAll()

        assertTrue(result is Result.Failure)
        val error = (result as Result.Failure).error
        assertTrue(error is NetworkError.Unknown)
    }

    @Test
    fun `네트워크 장애 시 NetworkUnavailable`() = runTest {
        coEvery { dataSource.findAll() } throws java.io.IOException("network down")

        val result = repository.findAll()

        assertTrue(result is Result.Failure)
        val error = (result as Result.Failure).error
        assertTrue(error is NetworkError.NetworkUnavailable)
    }

}
