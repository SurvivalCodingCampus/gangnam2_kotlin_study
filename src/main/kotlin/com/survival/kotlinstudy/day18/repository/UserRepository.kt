package com.survival.kotlinstudy.day18.repository

import com.survival.kotlinstudy.day18.dto.UserDto
import com.survival.kotlinstudy.day18.model.User
import com.survival.kotlinstudy.day18.util.NetworkError
import com.survival.kotlinstudy.day18.util.Result

interface UserRepository {
    suspend fun getUser(id: Int): Result<User, NetworkError>
    suspend fun getUsers(): Result<List<User>, NetworkError>
    suspend fun createUser(user: UserDto): Result<User, NetworkError>
}