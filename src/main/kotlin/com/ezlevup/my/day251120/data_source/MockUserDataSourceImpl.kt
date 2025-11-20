package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.User

class MockUserDataSourceImpl(
    private val users: List<User> = emptyList()
) : UserDataSource {
    override suspend fun getUsers(): List<User> {
        return users
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return users.sortedBy { it.username }.drop(10)
    }
}
