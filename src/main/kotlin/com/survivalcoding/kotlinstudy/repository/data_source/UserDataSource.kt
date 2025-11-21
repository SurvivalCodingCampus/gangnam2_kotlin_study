package com.survivalcoding.kotlinstudy.repository.data_source

import com.survivalcoding.kotlinstudy.User

interface UserDataSource {
    suspend fun getUser(id: Int): User?
    suspend fun getUsers(): List<User>

    // CRUD
}