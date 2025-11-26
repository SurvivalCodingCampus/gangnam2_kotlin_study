package com.survivalcoding.kotlinstudy.`18_result`.data_source

import com.survivalcoding.kotlinstudy.`18_result`.core.Response
import com.survivalcoding.kotlinstudy.`18_result`.dto.UserDto

interface UserDataSource {
    suspend fun getUser(id: Int): Response<UserDto>
    suspend fun getUsers(): Response<List<UserDto>>
    suspend fun createUser(userDto: UserDto): Response<UserDto>
}