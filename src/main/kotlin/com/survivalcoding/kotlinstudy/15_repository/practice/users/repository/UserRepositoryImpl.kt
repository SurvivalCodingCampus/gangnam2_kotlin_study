package com.survivalcoding.kotlinstudy.`15_repository`.practice.users.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.data_source.UserDataSource
import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.model.User

class UserRepositoryImpl(
    private val dataSource: UserDataSource
) : UserRepository {
    override suspend fun getUser(): List<User> {
        return dataSource.getUsersFileData()
    }

    override suspend fun getUserTop10ByUserName(): List<User> {
        val userSource = getUser()
        return userSource.sortedBy { it.name }.filterIndexed { index, _ -> index < 10 }
    }
}