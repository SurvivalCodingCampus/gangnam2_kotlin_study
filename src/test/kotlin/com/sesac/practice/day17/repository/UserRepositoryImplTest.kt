package com.sesac.practice.day17.repository

import com.sesac.practice.day17.core.NetworkError
import com.sesac.practice.day17.core.Response
import com.sesac.practice.day17.core.Result
import com.sesac.practice.day17.datasource.UserDataSource
import com.sesac.practice.day17.dto.UserDto
import com.sesac.practice.day17.model.User
import io.mockk.MockKAnnotations
import io.mockk.bdd.coGiven
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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
    fun `사용자 ID로 단일 사용자를 조회한다`() = runTest {
        // given
        val id = 1L
        val name = "name"

        coGiven { dataSource.getUser(id) } returns
                Response(
                    200,
                    mapOf(),
                    UserDto(id, name),
                )

        // when
        val result = repository.getUser(id)

        // then
        assertTrue(result is Result.Success)
        assertEquals(id, result.data.id)
        assertEquals(name, result.data.name)
    }

    @Test
    fun `전체 사용자 목록을 조회한다`() = runTest {
        // given
        coGiven { dataSource.getUsers() } returns
                Response(
                    200,
                    mapOf(),
                    listOf(
                        UserDto(1L, "name1"),
                        UserDto(2L, "name2"),
                    ),
                )

        // when
        val result = repository.getUsers()

        // then
        assertTrue(result is Result.Success)
        assertEquals(2, result.data.size)
        assertEquals(1L, result.data[0].id)
        assertEquals("name1", result.data[0].name)
    }

    @Test
    fun `새 사용자를 생성한다`() = runTest {
        // given
        val id = 1L
        val name = "name"

        coGiven { dataSource.createUser(any()) } returns
                Response(
                    200,
                    mapOf(),
                    UserDto(id, name),
                )

        // when
        val user = User(id, name)
        val result = repository.createUser(user)

        // then
        assertTrue(result is Result.Success)
        assertEquals(id, result.data.id)
        assertEquals(name, result.data.name)
    }

    @Test
    fun `타임아웃 10초가 넘을 경우 에러를 반환한다`() = runTest {
        // given
        val timeMillis = 10_000L
        val dataSource = TimeoutMockUserDataSourceImpl(timeMillis)
        val repository = UserRepositoryImpl(dataSource)

        // when
        val result = repository.getUsers()

        // then
        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.Timeout)
    }

    @Test
    fun `4xx 에러가 발생할 경우 에러를 반환한다`() = runTest {
        // given
        val statusCode = 400

        coGiven { dataSource.getUsers() } returns Response(statusCode, mapOf())

        // when
        val result = repository.getUsers()

        // then
        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.HttpError)
        assertEquals(statusCode, result.error.code)
    }

    @Test
    fun `5xx 에러가 발생할 경우 에러를 반환한다`() = runTest {
        // given
        val statusCode = 500

        coGiven { dataSource.getUsers() } returns Response(statusCode, mapOf())

        // when
        val result = repository.getUsers()

        // then
        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.HttpError)
        assertEquals(statusCode, result.error.code)
    }

    @Test
    fun `JSON 파싱 에러가 발생할 경우 에러를 반환한다`() = runTest {
        // given
        val dataSource = ParseErrorMockUserDataSourceImpl()
        val repository = UserRepositoryImpl(dataSource)

        // when
        val result = repository.getUsers()

        // then
        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.ParseError)
    }
}
