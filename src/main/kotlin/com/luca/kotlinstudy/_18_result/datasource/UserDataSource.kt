package com.luca.kotlinstudy._18_result.datasource

import com.luca.kotlinstudy._18_result.dto.UserDTO
import com.luca.kotlinstudy.core.Response

interface UserDataSource {
    suspend fun findById(userId: String): Response<UserDTO>
    suspend fun findAll(): Response<List<UserDTO>>
    suspend fun create(user: UserDTO): Response<UserDTO>
}
