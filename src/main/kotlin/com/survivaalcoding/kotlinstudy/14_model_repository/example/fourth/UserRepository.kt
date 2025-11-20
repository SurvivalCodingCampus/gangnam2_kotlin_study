package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fourth

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}