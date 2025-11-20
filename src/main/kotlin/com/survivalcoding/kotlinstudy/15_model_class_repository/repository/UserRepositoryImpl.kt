package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.UserDataSource
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.User

class UserRepositoryImpl(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return dataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return getUsers()
            .sortedBy { it.username }
            .take(10)
    }
}