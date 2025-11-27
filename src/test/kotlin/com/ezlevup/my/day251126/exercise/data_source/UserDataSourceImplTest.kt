package com.ezlevup.my.day251126.exercise.data_source

import com.ezlevup.my.day251126.exercise.dto.UserDto
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserDataSourceImplTest {
    @Before
    fun setUp() {

    }

    @Test
    fun getUsers(): Unit = runBlocking {
        // given
        val response = UserDataSourceImpl()

        // when
        val result = response.getUsers()

        // then
        assertEquals(result.status, HttpStatusCode.OK)
        println(result.body?.count())
    }

    @Test
    fun getUser(): Unit = runBlocking {
        // given
        val response = UserDataSourceImpl()

        // when
        val userId: Int = 1
        val result = response.getUser(userId)

        // then
        assertEquals(result.status, HttpStatusCode.OK)
        assertEquals(userId, result.body?.id)
    }

    @Test
    fun createUser(): Unit = runBlocking {
        // given
        val response = UserDataSourceImpl()

        // when
        val user: UserDto = UserDto()
        val result = response.createUser(user)

        // then
        assertEquals(result.status, HttpStatusCode.Created)
        println(result.body?.toString())
    }

}