package com.survivalcoding.kotlinstudy.`18_result`.data_source

import com.survivalcoding.kotlinstudy.`18_result`.dto.UserRequestDto
import com.survivalcoding.kotlinstudy.`18_result`.mock.TestHttpClientFactory
import com.survivalcoding.kotlinstudy.`18_result`.mock.UserDataSourceMockEngine
import io.ktor.client.engine.mock.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class UserDataSourceImplTest {

    @Test
    fun `GET users 성공 - 유저 목록`() = runTest {
        // given
        val engine: MockEngine = UserDataSourceMockEngine.getUsersSuccess()
        val client = TestHttpClientFactory.create(engine)
        val dataSource = UserDataSourceImpl(client)

        // when
        val response = dataSource.getUsers()

        // then
        assertEquals(200, response.statusCode)
        assertNotNull(response.body)
        assertEquals(10, response.body.size)
    }

    @Test
    fun `GET user(id) 성공 - 유저 1개 반환`() = runTest {
        // given
        val engine: MockEngine = UserDataSourceMockEngine.getUserSuccess()
        val client = TestHttpClientFactory.create(engine)
        val dataSource = UserDataSourceImpl(client)

        // when
        val response = dataSource.getUser(1)

        // then
        assertEquals(200, response.statusCode)
        assertNotNull(response.body)
    }

    @Test
    fun `POST 성공 - 유저 아이디 반환`() = runTest {
        // given
        val engine: MockEngine = UserDataSourceMockEngine.postUserSuccess()
        val client = TestHttpClientFactory.create(engine)
        val dataSource = UserDataSourceImpl(client)

        // when
        val response = dataSource.createUser(
            userDto = UserRequestDto(
                name = "New User",
                username = "newbie",
                email = "new@example.com",
            )
        )

        // then
        assertEquals(201, response.statusCode)
        assertEquals(11, response.body)
    }
}
