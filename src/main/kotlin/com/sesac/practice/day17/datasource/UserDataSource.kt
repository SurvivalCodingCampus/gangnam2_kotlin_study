package com.sesac.practice.day17.datasource

import com.sesac.practice.day17.core.Response
import com.sesac.practice.day17.dto.UserDto
import com.sesac.practice.day17.model.User

interface UserDataSource {
    suspend fun getUser(id: Long): Response<UserDto>
    suspend fun getUsers(): Response<List<UserDto>>
    suspend fun createUser(user: User): Response<UserDto>
}
