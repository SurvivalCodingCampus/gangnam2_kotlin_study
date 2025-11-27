package com.survivalcoding.kotlinstudy.`18_result`.practice.data_source

import com.survivalcoding.kotlinstudy.`18_result`.practice.dto.UserDto
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.User
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Response

interface UserDataSource {
    suspend fun getUser(id: Int): Response<UserDto>
    suspend fun getUsers(): Response<List<UserDto>>
    suspend fun createUser(user: User): Response<UserDto>
}