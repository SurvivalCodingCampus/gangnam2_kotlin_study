package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockUserDataSourceImpl
import com.survival.kotlinstudy.day15.datasource.UserDataSource
import com.survival.kotlinstudy.day15.model.User
import kotlinx.coroutines.runBlocking

class UserRepositoryImpl(
    private val dataSource: UserDataSource
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return dataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return dataSource.getUsers().sortedBy { it.username }.take(10)
    }
}

fun main() = runBlocking{
    val filePath ="data/users.json"
    val repository = UserRepositoryImpl(MockUserDataSourceImpl(filePath))

    println(repository.getUsers().joinToString("\n"))
    println("---------------------------------------------")
    println(repository.getUsersTop10ByUserName().joinToString("\n"))
}