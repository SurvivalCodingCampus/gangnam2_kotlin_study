package com.survivalcoding.kotlinstudy.`18_result`.repository

import com.survivalcoding.kotlinstudy.`18_result`.core.NetworkError
import com.survivalcoding.kotlinstudy.`18_result`.core.Result
import com.survivalcoding.kotlinstudy.`18_result`.model.User


interface UserRepository {
    suspend fun getUser(id: Int): Result<User, NetworkError>
    suspend fun getUsers(): Result<List<User>, NetworkError>
    suspend fun createUser(user: User): Result<User, NetworkError>
}