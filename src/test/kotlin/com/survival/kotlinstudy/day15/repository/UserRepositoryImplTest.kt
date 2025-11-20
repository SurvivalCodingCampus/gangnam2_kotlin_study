package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.FileUserDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class UserRepositoryImplTest {

    @Test
    fun `UserRepository - getUsers() 메소드 테스트`() = runBlocking {
        val filePath = "data/users.json"
        val repository = UserRepositoryImpl(FileUserDataSourceImpl(filePath))
        val expected = 10

        assertEquals(expected, repository.getUsers().size)
    }

    @Test
    fun `UserRepository - getUsersTop10ByUserName() 메소드 테스트`() = runBlocking {
        val filePath = "data/users.json"
        val repository = UserRepositoryImpl(FileUserDataSourceImpl(filePath))
        val expected = 10

        assertEquals(expected, repository.getUsersTop10ByUserName().size)
    }
}