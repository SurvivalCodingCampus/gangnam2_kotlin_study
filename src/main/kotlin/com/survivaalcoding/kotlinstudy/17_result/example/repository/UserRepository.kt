package com.survivaalcoding.kotlinstudy.`17_result`.example.repository

import com.survivaalcoding.kotlinstudy.`17_result`.example.core.Result
import com.survivaalcoding.kotlinstudy.`17_result`.example.dto.UserDto
import com.survivaalcoding.kotlinstudy.`17_result`.example.exception.NetworkError
import com.survivaalcoding.kotlinstudy.`17_result`.example.model.User

interface UserRepository {
    suspend fun findAll(): Result<List<User>, NetworkError>
    suspend fun findById(id: Long): Result<User, NetworkError>
    suspend fun save(userDto: UserDto): Result<Long, NetworkError>
}