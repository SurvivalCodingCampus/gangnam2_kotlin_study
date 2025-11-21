package com.survivalcoding.kotlinstudy.repository.repository

import com.survivalcoding.kotlinstudy.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}