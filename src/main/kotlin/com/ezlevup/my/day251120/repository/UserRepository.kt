package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}