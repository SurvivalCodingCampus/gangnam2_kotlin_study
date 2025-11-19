package com.survival.kotlinstudy.datasource

interface UserDataSource {
    suspend fun getUsers(): List<User>
}