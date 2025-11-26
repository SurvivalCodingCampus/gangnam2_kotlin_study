package com.luca.kotlinstudy._18_result.repository

import com.luca.kotlinstudy.core.Result
import com.luca.kotlinstudy.core.NetworkError
import com.luca.kotlinstudy._18_result.model.User

typealias UserResult<T> = Result<T, NetworkError>

interface UserRepository {
    suspend fun findById(userId: String): UserResult<User>
    suspend fun findAll(): UserResult<List<User>>
    suspend fun create(user: User): UserResult<User>
}