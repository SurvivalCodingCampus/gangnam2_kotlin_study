package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockUserDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class UserRepositoryImplTest {

    @Test
    fun `UserRepository - getUsers() 메소드 테스트`() = runBlocking {
        val repository = UserRepositoryImpl(MockUserDataSourceImpl())
        val expected = 10

        assertEquals(expected, repository.getUsers().size)
    }

    @Test
    fun `UserRepository - getUsersTop10ByUserName() 메소드 테스트`() = runBlocking {

        val repository = UserRepositoryImpl(MockUserDataSourceImpl())

        val list = repository.getUsersTop10ByUserName()


        assertEquals(list[0].username, "a")
        assertEquals(list[1].username, "b")
        assertEquals(list[2].username, "c")
        assertEquals(list[3].username, "d")
        assertEquals(list[4].username, "e")
        assertEquals(list[5].username, "f")
        assertEquals(list[6].username, "g")
        assertEquals(list[7].username, "h")
        assertEquals(list[8].username, "i")
        assertEquals(list[9].username, "j")
    }
}