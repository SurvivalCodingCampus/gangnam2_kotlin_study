package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.user

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.User

interface UserDataSource {
    suspend fun getUsers(): List<User>
}