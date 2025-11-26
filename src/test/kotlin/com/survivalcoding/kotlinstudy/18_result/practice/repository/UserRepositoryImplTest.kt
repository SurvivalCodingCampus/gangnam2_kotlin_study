package com.survivalcoding.kotlinstudy.`18_result`.practice.repository

import com.survivalcoding.kotlinstudy.`18_result`.practice.data_source.MockUserDataSourceImpl
import com.survivalcoding.kotlinstudy.`18_result`.practice.data_source.NetworkErrorMockEngine
import com.survivalcoding.kotlinstudy.`18_result`.practice.data_source.UserDataSource
import com.survivalcoding.kotlinstudy.`18_result`.practice.dto.UserDto
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.Address
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.Company
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.Geo
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.User
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.NetworkError
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Response
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Result
import io.ktor.client.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.SerializationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class UserRepositoryImplTest {

    private val dataSource = MockUserDataSourceImpl()
    private val repository = UserRepositoryImpl(dataSource)

    @Test
    fun `getUserById(id)가 잘 동작하는지 확인`() = runBlocking {
        val result: Result<User, NetworkError> = repository.getUserById(4)

        val expectedId = 4
        val expectedName = "Patricia Lebsack"
        val expectedUserName = "Karianne"

        when (result) {
            is Result.Success -> {
                val user: User = result.data

                assertEquals(expectedId, user.id)
                assertEquals(expectedName, user.name)
                assertEquals(expectedUserName, user.username)
            }

            is Result.Error -> {
                fail()
            }
        }
    }

    @Test
    fun `getAllUsers()가 잘 동작하는지 확인`() = runBlocking {
        val result: Result<List<User>, NetworkError> = repository.getAllUsers()

        val expectedSize = 10

        when (result) {
            is Result.Success -> {
                val users: List<User> = result.data

                assertEquals(expectedSize, users.size)
            }

            is Result.Error -> {
                fail()
            }
        }
    }

    @Test
    fun `createUser(user)가 잘 동작하는지 확인`() = runBlocking {
        val result: Result<User, NetworkError> = repository.createUser(
            User(
                id = 11,
                name = "Test User",
                username = "testuser",
                email = "test@example.com",
                address = Address(
                    street = "Test Street",
                    suite = "Apt. 101",
                    city = "Seoul",
                    zipcode = "00000",
                    geo = Geo(
                        lat = "37.5665",
                        lng = "126.9780"
                    )
                ),
                phone = "010-0000-0000",
                website = "example.com",
                company = Company(
                    name = "Test Company",
                    catchPhrase = "Testing the world",
                    bs = "test-services"
                )
            )
        )

        val expectedId = 11
        val expectedName = "Test User"
        val expectedUserName = "testuser"

        when (result) {
            is Result.Success -> {
                val user: User = result.data

                assertEquals(expectedId, user.id)
                assertEquals(expectedName, user.name)
                assertEquals(expectedUserName, user.username)
            }

            is Result.Error -> {
                fail()
            }
        }
    }

    @Test
    fun `타임 아웃 발생시 NetworkError_Timeout 나오는지 확인`() = runTest {
        val fakeDataSource = object : UserDataSource {
            override suspend fun getUser(id: Int): Response<UserDto> {
                withTimeout(10_000L) {
                    delay(11_000L)
                }
                error("Error")
            }

            override suspend fun getUsers(): Response<List<UserDto>> {
                withTimeout(10_000L) {
                    delay(11_000L)
                }
                error("Error")
            }

            override suspend fun createUser(user: User): Response<UserDto> {
                withTimeout(10_000L) {
                    delay(11_000L)
                }
                error("Error")
            }
        }

        val repository = UserRepositoryImpl(fakeDataSource)

        val result = repository.getAllUsers()

        when (result) {
            is Result.Success -> {
                fail()
            }

            is Result.Error -> {
                assertEquals(NetworkError.Timeout, result.error)
            }
        }
    }

    @Test
    fun `Http 상태코드별 NetworkError가 맞게 나오는지 확인`() = runTest {
        val client = HttpClient(NetworkErrorMockEngine.mockEngine)
        val fakeDataSource = MockUserDataSourceImpl(client)
        val repository = UserRepositoryImpl(fakeDataSource)

        val result1 = repository.getUserById(1)
        val result2 = repository.getUserById(2)
        val result3 = repository.getUserById(3)

        when (result1) {
            is Result.Success -> {
                fail()
            }

            is Result.Error -> {
                assertEquals(NetworkError.ClientError(400), result1.error)
            }
        }

        when (result2) {
            is Result.Success -> {
                fail()
            }

            is Result.Error -> {
                assertEquals(NetworkError.ServerError(500), result2.error)
            }
        }

        when (result3) {
            is Result.Success -> {
                fail()
            }

            is Result.Error -> {
                assertEquals(NetworkError.HttpError(300), result3.error)
            }
        }
    }

    @Test
    fun `JSON 파싱 에러시 NetworkError_ParseError 나오는지 확인`() = runTest {
        val fakeDataSource = object : UserDataSource {
            override suspend fun getUser(id: Int): Response<UserDto> {
                throw SerializationException("")
            }

            override suspend fun getUsers(): Response<List<UserDto>> {
                throw SerializationException("")
            }

            override suspend fun createUser(user: User): Response<UserDto> {
                throw SerializationException("")
            }
        }

        val repository = UserRepositoryImpl(fakeDataSource)

        val result = repository.getUserById(1)

        when (result) {
            is Result.Success -> {
                fail()
            }

            is Result.Error -> {
                assertEquals(NetworkError.ParseError, result.error)
            }
        }
    }
}