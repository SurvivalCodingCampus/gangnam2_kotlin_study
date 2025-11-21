package com.luca.kotlinstudy._15_model_repository.repository.user

import com.luca.kotlinstudy._15_model_repository.dataSource.user.UserDatasource
import com.luca.kotlinstudy._15_model_repository.model.User

class UserRepositoryImpl(
    private val dataSource: UserDatasource
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return dataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return dataSource.getUsers().sortedBy { it.username }.take(10)
    }
}