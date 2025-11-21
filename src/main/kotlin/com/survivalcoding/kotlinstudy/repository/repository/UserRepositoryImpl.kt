package com.survivalcoding.kotlinstudy.repository.repository

import com.survivalcoding.kotlinstudy.User
import com.survivalcoding.kotlinstudy.repository.data_source.UserDataSource

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return userDataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return getUsers().sortedBy { it.name }
            .take(10)
    }
}