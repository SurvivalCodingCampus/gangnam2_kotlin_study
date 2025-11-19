package com.sesac.practice.day13

interface UserDataSource {
    suspend fun getUsers(): List<User>
}
