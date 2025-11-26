package com.ezlevup.my.day251126.exercise.repository

import com.ezlevup.my.core.RepositoryResult
import com.ezlevup.my.day251126.exercise.data_source.UserDataSourceImpl
import com.ezlevup.my.day251126.exercise.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class UserRepositoryImplTest {
    @Before
    fun setUp() {

    }

    @Test
    fun getUser(): Unit = runBlocking {
        // given
        val repository = UserRepositoryImpl(UserDataSourceImpl())

        // when
        val userId = 1
        val result = repository.getUser(userId)

        // then
        when (result) {
            is RepositoryResult.Success -> {
                val user = result.data
                assertNotNull(user)
                assertEquals(userId, user.id)
            }

            is RepositoryResult.Error -> {
                val error = result.error
                println(error.toString())
            }
        }
    }

    @Test
    fun getUsers(): Unit = runBlocking {
        // given
        val repository = UserRepositoryImpl(UserDataSourceImpl())

        // when
        val userId = 1
        val result = repository.getUsers()

        // then
        when (result) {
            is RepositoryResult.Success -> {
                val users = result.data
                assertNotNull(users)
            }

            is RepositoryResult.Error -> {
                val error = result.error
                println(error.toString())
            }
        }
    }

    @Test
    fun createUser(): Unit = runBlocking {
        // given
        val repository = UserRepositoryImpl(UserDataSourceImpl())

        // when
        val user = User(id = 11)
        val result = repository.createUser(user)

        // then
        when (result) {
            is RepositoryResult.Success -> {
                val userData: User = result.data
                assertNotNull(user)
                assertEquals(user.id, userData.id)
                println(user.toString())
            }

            is RepositoryResult.Error -> {
                val error = result.error
                println(error.toString())
            }
        }
    }

}