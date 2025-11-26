package com.survivaalcoding.kotlinstudy.`17_result`.example.repository

import com.survivaalcoding.kotlinstudy.`17_result`.example.core.Response
import com.survivaalcoding.kotlinstudy.`17_result`.example.core.Result
import com.survivaalcoding.kotlinstudy.`17_result`.example.datasource.DataSource
import com.survivaalcoding.kotlinstudy.`17_result`.example.dto.UserDto
import com.survivaalcoding.kotlinstudy.`17_result`.example.exception.NetworkError
import com.survivaalcoding.kotlinstudy.`17_result`.example.model.User
import io.mockk.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.SerializationException
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.coroutines.cancellation.CancellationException

class UserRepositoryImplTest {
    private lateinit var dataSource: DataSource
    private lateinit var repository: UserRepository

    @Before
    fun setUp() {
        dataSource = mockk()
        repository = UserRepositoryImpl(dataSource)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `전체 사용자 조회`() = runTest {
        // given
        val id1 = 1L
        val id2 = 2L
        val email1 = "user1@gmail.com"
        val email2 = "user2@gmail.com"
        val name1 = "user1"
        val name2 = "user2"
        val users = listOf(
            User(id1, email1, name1),
            User(id2, email2, name2),
        )

        val mockUserDto = listOf(
            UserDto(id1, email1, name1),
            UserDto(id2, email2, name2)
        )
        val mockResponse = mockk<Response<List<UserDto>>> {
            every { body } returns mockUserDto
        }
        coEvery { dataSource.findAll() } returns mockResponse

        // when
        val result = repository.findAll()

        // then
        assertTrue(result is Result.Success)

        result as Result.Success
        assertEquals(2, result.data.size)
        assertEquals(users, result.data)
        coVerify(exactly = 1) { dataSource.findAll() }
    }

    @Test
    fun `전체 사용자 조회가 null일 때 빈 리스트를 반환한다`() = runTest {
        // given
        val mockResponse = mockk<Response<List<UserDto>>> {
            every { body } returns null
        }
        coEvery { dataSource.findAll() } returns mockResponse

        // when
        val result = repository.findAll()

        // then
        assertTrue(result is Result.Success)

        result as Result.Success
        assertEquals(0, result.data.size)
        coVerify(exactly = 1) { dataSource.findAll() }
    }

    @Test
    fun `전체 사용자 조회 id가 null이면 필터링 된다`() = runTest {
        // given
        val id1 = null
        val id2 = 2L
        val email1 = "user1@gmail.com"
        val email2 = "user2@gmail.com"
        val name1 = "user1"
        val name2 = "user2"
        val users = listOf(
            User(id2, email2, name2),
        )

        val mockUserDto = listOf(
            UserDto(id1, email1, name1),
            UserDto(id2, email2, name2)
        )
        val mockResponse = mockk<Response<List<UserDto>>> {
            every { body } returns mockUserDto
        }
        coEvery { dataSource.findAll() } returns mockResponse

        // when
        val result = repository.findAll()

        // then
        assertTrue(result is Result.Success)

        result as Result.Success
        assertEquals(1, result.data.size)
        assertEquals(users, result.data)
        coVerify(exactly = 1) { dataSource.findAll() }
    }

    @Test
    fun `전체 사용자 조회 시 역직렬화 실패하면 예외가 발생한다`() = runTest {
        // given
        coEvery { dataSource.findAll() } throws SerializationException()

        // when
        val result = repository.findAll()

        // then
        assertTrue(result is Result.Failure)

        result as Result.Failure
        assertTrue(result.error is NetworkError.ParseError)
        coVerify(exactly = 1) { dataSource.findAll() }
    }

    @Test
    fun `전체 사용자 조회 시 시간 초과가 발생하면 예외가 발생한다`() = runTest {
        // given
        coEvery { dataSource.findAll() } throws CancellationException()

        // when
        val result = repository.findAll()

        // then
        assertTrue(result is Result.Failure)

        result as Result.Failure
        assertTrue(result.error is NetworkError.Timeout)
        coVerify(exactly = 1) { dataSource.findAll() }
    }

    @Test
    fun `ID로 사용자 조회`() = runTest {
        // given
        val id = 1L
        val email = "user1@gmail.com"
        val name = "user1"
        val user = User(id, email, name)

        val mockUserDto = UserDto(id, email, name)
        val mockResponse = mockk<Response<UserDto>> {
            every { body } returns mockUserDto
        }
        coEvery { dataSource.findById(id) } returns mockResponse

        // when
        val result = repository.findById(id)

        // then
        assertTrue(result is Result.Success)

        result as Result.Success
        assertEquals(user, result.data)
        coVerify(exactly = 1) { dataSource.findById(id) }
    }

    @Test
    fun `존재하지 않는 ID로 사용자 조회 시 실패 결과를 반환한다`() = runTest {
        // given
        val id = Long.MAX_VALUE
        val mockResponse = mockk<Response<UserDto>> {
            every { body } returns null
        }
        coEvery { dataSource.findById(id) } returns mockResponse

        // when
        val result = repository.findById(id)

        // then
        assertTrue(result is Result.Failure)

        result as Result.Failure
        assertTrue(result.error is NetworkError.HttpError)

        result.error as NetworkError.HttpError
        assertEquals(404, result.error.code)
        coVerify(exactly = 1) { dataSource.findById(id) }
    }

    @Test
    fun `ID로 사용자 조회 시 역직렬화 실패하면 예외가 발생한다`() = runTest {
        // given
        val id = 1L
        coEvery { dataSource.findById(id) } throws SerializationException()

        // when
        val result = repository.findById(id)

        // then
        assertTrue(result is Result.Failure)

        result as Result.Failure
        assertTrue(result.error is NetworkError.ParseError)
        coVerify(exactly = 1) { dataSource.findById(id) }
    }

    @Test
    fun `ID로 사용자 조회 시 시간 초과가 발생하면 예외가 발생한다`() = runTest {
        // given
        val id = 1L
        coEvery { dataSource.findById(id) } throws CancellationException()

        // when
        val result = repository.findById(id)

        // then
        assertTrue(result is Result.Failure)

        result as Result.Failure
        assertTrue(result.error is NetworkError.Timeout)
        coVerify(exactly = 1) { dataSource.findById(id) }
    }

    @Test
    fun `사용자를 생성한다`() = runTest {
        // given
        val id = 1L
        val email = "user1@gmail.com"
        val name = "user1"
        val savedUser = UserDto(email = email, name = name)

        val mockUserDto = UserDto(id, email, name)
        val mockResponse = mockk<Response<UserDto>> {
            every { body } returns mockUserDto
        }
        coEvery { dataSource.save(savedUser) } returns mockResponse

        // when
        val result = repository.save(savedUser)

        // then
        assertTrue(result is Result.Success)

        result as Result.Success
        assertEquals(id, result.data)
        coVerify(exactly = 1) { dataSource.save(savedUser) }
    }

    @Test
    fun `사용자 생성 실패로 null이면 실패 결과를 반환한다`() = runTest {
        // given
        val email = "user1@gmail.com"
        val name = "user1"
        val savedUser = UserDto(email = email, name = name)

        val mockResponse = mockk<Response<UserDto>> {
            every { body } returns null
        }
        coEvery { dataSource.save(savedUser) } returns mockResponse

        // when
        val result = repository.save(savedUser)

        // then
        assertTrue(result is Result.Failure)

        result as Result.Failure
        assertTrue(result.error is NetworkError.HttpError)

        result.error as NetworkError.HttpError
        assertEquals(500, result.error.code)
        coVerify(exactly = 1) { dataSource.save(savedUser) }
    }

    @Test
    fun `사용자 생성 시 역직렬화 실패하면 예외가 발생한다`() = runTest {
        // given
        val email = "user1@gmail.com"
        val name = "user1"
        val savedUser = UserDto(email = email, name = name)

        coEvery { dataSource.save(savedUser) } throws SerializationException()

        // when
        val result = repository.save(savedUser)

        // then
        assertTrue(result is Result.Failure)

        result as Result.Failure
        assertTrue(result.error is NetworkError.ParseError)
        coVerify(exactly = 1) { dataSource.save(savedUser) }
    }

    @Test
    fun `사용자 생성 시 시간 초과가 발생하면 예외가 발생한다`() = runTest {
        // given
        val email = "user1@gmail.com"
        val name = "user1"
        val savedUser = UserDto(email = email, name = name)

        coEvery { dataSource.save(savedUser) } throws CancellationException()

        // when
        val result = repository.save(savedUser)

        // then
        assertTrue(result is Result.Failure)

        result as Result.Failure
        assertTrue(result.error is NetworkError.Timeout)
        coVerify(exactly = 1) { dataSource.save(savedUser) }
    }
}