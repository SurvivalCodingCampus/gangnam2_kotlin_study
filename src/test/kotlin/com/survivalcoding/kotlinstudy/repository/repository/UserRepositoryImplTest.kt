package com.survivalcoding.kotlinstudy.repository.repository

import com.survivalcoding.kotlinstudy.repository.data_source.MockUserDataSourceImpl
import com.survivalcoding.kotlinstudy.repository.data_source.UserDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class UserRepositoryImplTest {
    private val mockUserDataSource: UserDataSource = MockUserDataSourceImpl()
    private val userRepository: UserRepository = UserRepositoryImpl(mockUserDataSource)

    @Test
    fun getUsers() = runBlocking {
        val users = userRepository.getUsers()

        assertEquals(11, users.size)
    }

    @Test
    fun getUsersTop10ByUserName() = runBlocking {
        val users = userRepository.getUsersTop10ByUserName()

        assertEquals(10, users.size)
    }
}