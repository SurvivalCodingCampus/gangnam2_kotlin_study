package com.neouul.sesac.`16-result-pattern`.data_source

import com.neouul.sesac.`16-result-pattern`.dto.UserDTO
import com.neouul.sesac.`16-result-pattern`.model.User
import com.neouul.sesac.core.Response

interface UserDataSource {
    suspend fun getUser(userId: Int): Response<UserDTO?>
    suspend fun getUsers(): Response<List<UserDTO?>?>
    suspend fun createUser(user: User): Response<UserDTO?>
}