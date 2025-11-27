package com.neouul.sesac.`16-result-pattern`.repository

import com.neouul.sesac.`16-result-pattern`.core.NetworkError
import com.neouul.sesac.`16-result-pattern`.data_source.MockUserDataSourceImpl
import com.neouul.sesac.`16-result-pattern`.data_source.UserDataSource
import com.neouul.sesac.`16-result-pattern`.dto.UserDTO
import com.neouul.sesac.`16-result-pattern`.model.User
import com.neouul.sesac.core.Result
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.Assert.*
import org.junit.Test

class UserRepositoryImplTest {

    private val mockDataSource: UserDataSource = MockUserDataSourceImpl()
    private val userRepository: UserRepository = UserRepositoryImpl(mockDataSource)

    @Test
    fun `createUser 메서드 성공 - 이름이 Success인 User 객체`() = runBlocking {
        // given
        val expected = User(101, "Success", "S", "s@email.com", "1-1-1")

        // when
        val result = userRepository.createUser(expected)

        // then
        assertTrue(result is Result.Success)
        if (result is Result.Success) {
            assertEquals(expected.userId, result.data.userId)
            assertEquals(expected.name, result.data.name)
            assertEquals(expected.userName, result.data.userName)
            assertEquals(expected.email, result.data.email)
            assertEquals(expected.phone, result.data.phone)
        }
    }

    @Test
    fun `createUser 메서드 실패 - 이름이 404인 User 객체 HttpError`() = runBlocking {
        // given
        val expected = User(101, "404", "S", "s@email.com", "1-1-1")

        // when
        val result = userRepository.createUser(expected)

        // then
        assertTrue(result is Result.Error)
        if (result is Result.Error) {
            assertEquals(
                NetworkError.HttpError(STATUS_NOT_FOUND_VALUE),
                result.error,
            )
        }
    }

    @Test
    fun `createUser 메서드 실패 - 이름이 304인 User 객체 Unknown`() = runBlocking {
        // given
        val expected = User(101, "304", "S", "s@email.com", "1-1-1")

        // when
        val result = userRepository.createUser(expected)

        // then
        assertTrue(result is Result.Error)
        if (result is Result.Error) {
            assertEquals(NetworkError.Unknown("상태 코드 : $STATUS_NOT_MODIFIED_VALUE"), result.error)
        }
    }

    // 타임아웃 1ms로 가정하고, 100ms delay하도록 테스트
    @Test
    fun `createUser 메서드 실패 - 이름이 Timeout인 User 객체 Timeout`() = runBlocking {
        // given
        val expected = User(101, "Timeout", "S", "s@email.com", "1-1-1")

        // when
        val result = userRepository.createUser(expected)

        // then
        assertTrue(result is Result.Error)
        if (result is Result.Error) {
            assertEquals(NetworkError.Timeout, result.error)
        }
    }

    companion object {
        private const val STATUS_OK_VALUE = 200
        private const val STATUS_NOT_FOUND_VALUE = 404
        private const val STATUS_NOT_MODIFIED_VALUE = 304
        private const val STATUS_BAD_GATEWAY_VALUE = 502
    }

    @Test
    fun `findUser 메서드 성공 - userId가 101인 단일 사용자 조회`() = runBlocking {
        // given
        val validJson = """{
    "id": 101,
    "name": "Alex Johnson",
    "username": "alexj",
    "email": "alex.j@example.com",
    "phone": "1-555-123-4567"
  }"""
        val expected = Json.decodeFromString<UserDTO>(validJson)

        // when
        val result = userRepository.findUser(101)

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
    fun `findUser 메서드 실패 - userId가 104면 Json 파싱 실패`() = runBlocking {
        // given

        // when
        val result = userRepository.findUser(104)

        // then
        assertTrue(result is Result.Error)
        if (result is Result.Error) {
            assertEquals(NetworkError.ParseError, result.error)
        }
    }
}