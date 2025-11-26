package com.hhp227.kotlinstudy.`17_result`.datasource

import com.hhp227.kotlinstudy.`17_result`.User
import com.hhp227.kotlinstudy.`17_result`.Response

interface UserDataSource {
    suspend fun getUserById(id: Int): Response<User?>

    suspend fun getAllUsers(): Response<List<User>>

    suspend fun addUser(user: User): Response<Boolean>
}