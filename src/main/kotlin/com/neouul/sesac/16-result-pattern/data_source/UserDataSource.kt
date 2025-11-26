package com.neouul.sesac.`16-result-pattern`.data_source

import com.neouul.sesac.`16-result-pattern`.model.User
import com.neouul.sesac.core.Response

interface UserDataSource {
    suspend fun getUser(userId: Int): Response<User?>
    suspend fun getUsers(): Response<List<User?>?>
    suspend fun createUser(): Response<User?>
}