package com.survivalcoding.kotlinstudy.`15_repository`.practice.users.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.model.User

interface UserRepository {
    suspend fun getUser(): List<User>
    suspend fun getUserTop10ByUserName(): List<User>
}