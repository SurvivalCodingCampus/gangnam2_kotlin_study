package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository.user

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}