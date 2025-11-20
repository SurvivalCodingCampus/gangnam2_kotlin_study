package com.luca.kotlinstudy._15_model_repository.repository.user

import com.luca.kotlinstudy._15_model_repository.model.User

interface UserRepository {
    suspend fun getUsers() : List<User>
    suspend fun getUsersTop10ByUserName() : List<User>
}