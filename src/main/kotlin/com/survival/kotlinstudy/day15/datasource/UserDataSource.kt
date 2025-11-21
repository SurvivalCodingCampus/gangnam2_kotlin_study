package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.User

interface UserDataSource {
    suspend fun getUsers(): List<User>
}