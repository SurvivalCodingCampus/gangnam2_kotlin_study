package com.survival.kotlinstudy.day18.datasource

import com.survival.kotlinstudy.day18.core.Response
import com.survival.kotlinstudy.day18.dto.UserDto

interface UserDataSource {
    suspend fun getUser(id: Int): Response<UserDto>
    suspend fun getUsers(): Response<List<UserDto>>
    suspend fun createUser(user: UserDto): Response<UserDto>
}