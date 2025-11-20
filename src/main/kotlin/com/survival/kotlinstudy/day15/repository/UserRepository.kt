package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>

}