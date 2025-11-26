package com.ezlevup.my.day251126.exercise.data_source

import com.ezlevup.my.core.Response
import com.ezlevup.my.day251126.exercise.dto.UserDto


interface UserDataSource {
    suspend fun getUsers(): Response<List<UserDto>>
    suspend fun getUser(id: Int): Response<UserDto>
    suspend fun createUser(user: UserDto): Response<UserDto>
}
