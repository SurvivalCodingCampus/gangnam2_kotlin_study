package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.data_source.UserDataSource
import com.ezlevup.my.day251120.model.User

class UserRepositoryImpl(
    val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return userDataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return userDataSource.getUsersTop10ByUserName()
    }
}
