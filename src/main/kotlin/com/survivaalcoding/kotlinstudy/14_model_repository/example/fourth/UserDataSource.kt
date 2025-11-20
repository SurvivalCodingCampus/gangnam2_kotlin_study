package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fourth

interface UserDataSource {
    suspend fun getUser(): List<User>
}
