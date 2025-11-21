package com.luca.kotlinstudy._15_model_repository.dataSource.user

import com.luca.kotlinstudy._15_model_repository.model.User

interface UserDatasource {
    suspend fun getUsers() : List<User>
}