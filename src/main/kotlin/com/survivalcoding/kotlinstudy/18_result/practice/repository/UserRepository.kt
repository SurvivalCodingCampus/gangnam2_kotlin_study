package com.survivalcoding.kotlinstudy.`18_result`.practice.repository

import com.survivalcoding.kotlinstudy.`18_result`.practice.model.User
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.NetworkError
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Result

interface UserRepository {
    suspend fun getUserById(id: Int): Result<User, NetworkError>
    suspend fun getAllUsers(): Result<List<User>, NetworkError>
    suspend fun createUser(user: User): Result<User, NetworkError>
}