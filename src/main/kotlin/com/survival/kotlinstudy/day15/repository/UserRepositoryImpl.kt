package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.UserDataSource
import com.survival.kotlinstudy.day15.model.User

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