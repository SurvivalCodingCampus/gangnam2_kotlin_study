package com.survivaalcoding.kotlinstudy.`17_result`.example.datasource

import com.survivaalcoding.kotlinstudy.`17_result`.example.core.Response
import com.survivaalcoding.kotlinstudy.`17_result`.example.dto.UserDto

interface DataSource {
    suspend fun findAll(): Response<List<UserDto>>
    suspend fun findById(id: Long): Response<UserDto>
    suspend fun save(userDto: UserDto): Response<UserDto>
}