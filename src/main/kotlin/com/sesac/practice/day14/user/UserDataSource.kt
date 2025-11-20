package com.sesac.practice.day14.user

interface UserDataSource {
    suspend fun getUsers(): List<User>
}
