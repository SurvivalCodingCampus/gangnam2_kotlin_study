package com.sesac.practice.day17.repository

import com.sesac.practice.day17.core.NetworkError
import com.sesac.practice.day17.core.Result
import com.sesac.practice.day17.model.User

interface UserRepository {
    suspend fun getUser(id: Long): Result<User, NetworkError>
    suspend fun getUsers(): Result<List<User>, NetworkError>
    suspend fun createUser(user: User): Result<User, NetworkError>
}
