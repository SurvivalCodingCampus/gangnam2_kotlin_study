package com.neouul.sesac.`16-result-pattern`.repository

import com.neouul.sesac.`16-result-pattern`.core.NetworkError
import com.neouul.sesac.`16-result-pattern`.data_source.UserDataSource
import com.neouul.sesac.`16-result-pattern`.dto.UserDTO
import com.neouul.sesac.core.Response
import com.neouul.sesac.core.Result
import io.ktor.http.HttpStatusCode
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.Assert.*
import org.junit.Test

class MockkUserRepositoryImplTest {
    private val jsonString = """[
  {
    "id": 101,
    "name": "Alex Johnson",
    "username": "alexj",
    "email": "alex.j@example.com",
    "phone": "1-555-123-4567"
  },
  {
    "id": 102,
    "name": "Samantha Lee",
    "username": "samanthal",
    "email": "sam.lee@example.com",
    "phone": "1-555-987-6543"
  },
  {
    "id": 103,
    "name": "Michael Chen",
    "username": "mikec",
    "email": "michael.c@example.com",
    "phone": "1-555-500-1000"
  },
  {
    "id": null,
    "name": "Guest User",
    "username": null,
    "email": "guest@example.com",
    "phone": null
  }
]"""
    private val user101Json = """{
    "id": 101,
    "name": "Alex Johnson",
    "username": "alexj",
    "email": "alex.j@example.com",
    "phone": "1-555-123-4567"
  }"""
    private val invalidJson = """{
    "id": "??",
    "name": "Guest User",
    "username": null,
    "email": "guest@example.com",
    "phone": null
  }"""

    private val mockDataSource: UserDataSource = mockk<UserDataSource>()
    private val userRepository: UserRepository = UserRepositoryImpl(mockDataSource)

    private val headers = mapOf("Content-Type" to listOf("application/json"))
    private val STATUS_OK_VALUE = HttpStatusCode.OK.value
    private val STATUS_NOT_FOUND_VALUE = HttpStatusCode.NotFound.value
    private val STATUS_NOT_MODIFIED_VALUE = HttpStatusCode.NotModified.value

    @Test
    fun `findUser 메서드 성공 - userId가 101인 단일 사용자 조회`() = runBlocking {
        // given
        val userId = 101
        val expected = Json.decodeFromString<UserDTO>(user101Json)

        coEvery { mockDataSource.getUser(userId) } returns
                Response(
                    STATUS_OK_VALUE,
                    headers,
                    expected
                )

        // when
        val result = userRepository.findUser(userId)

        // then
        assertTrue(result is Result.Success)
        if (result is Result.Success) {
            assertEquals(expected.id, result.data.userId)
            assertEquals(expected.name, result.data.name)
            assertEquals(expected.username, result.data.userName)
            assertEquals(expected.email, result.data.email)
            assertEquals(expected.phone, result.data.phone)
        }
    }

    @Test
    fun `findUser 메서드 실패 - 상태 코드가 404라서 HttpError`() = runBlocking {
        // given
        val userId = 102

        coEvery { mockDataSource.getUser(userId) } returns
                Response(
                    STATUS_NOT_FOUND_VALUE,
                    headers,
                    null
                )

        // when
        val result = userRepository.findUser(userId)

        println(result)
        // then
        assertTrue(result is Result.Error)
        if (result is Result.Error) {
            assertEquals(NetworkError.HttpError(STATUS_NOT_FOUND_VALUE), result.error)
        }
    }

    @Test
    fun `findUser 메서드 실패 - 상태 코드가 300번대라서 Unknown`() = runBlocking {
        // given
        val userId = 103

        coEvery { mockDataSource.getUser(userId) } returns
                Response(
                    STATUS_NOT_MODIFIED_VALUE,
                    headers,
                    null
                )

        // when
        val result = userRepository.findUser(userId)

        // then
        assertTrue(result is Result.Error)
        if (result is Result.Error) {
            assertEquals(NetworkError.Unknown("상태 코드 : $STATUS_NOT_MODIFIED_VALUE"), result.error)
        }
    }

    @Test
    fun `findUsers 메서드 실패 - HttpError`() = runBlocking {
        // given
        coEvery { mockDataSource.getUsers() } returns
                Response(
                    STATUS_NOT_FOUND_VALUE,
                    headers,
                    null
                )

        // when
        val result = userRepository.findAllUsers()

        // then
        assertTrue(result is Result.Error)
        if (result is Result.Error) {
            assertEquals(NetworkError.HttpError(STATUS_NOT_FOUND_VALUE), result.error)
        }
    }

    @Test
    fun `findUsers 메서드 실패 - Unknown`() = runBlocking {
        // given
        coEvery { mockDataSource.getUsers() } returns
                Response(
                    STATUS_NOT_MODIFIED_VALUE,
                    headers,
                    null
                )

        // when
        val result = userRepository.findAllUsers()

        // then
        assertTrue(result is Result.Error)
        if (result is Result.Error) {
            assertEquals(NetworkError.Unknown("상태 코드 : $STATUS_NOT_MODIFIED_VALUE"), result.error)
        }
    }
}

//when (result) {
//    is Result.Success -> assertEquals(userId, result.data)
//    is Result.Error ->
//    when (result.error) {
//        NetworkError.NetworkUnavailable -> TODO()
//        NetworkError.Timeout -> TODO()
//        NetworkError.ParseError -> TODO()
//        is NetworkError.HttpError -> TODO()
//        is NetworkError.Unknown -> TODO()
//    }
//}