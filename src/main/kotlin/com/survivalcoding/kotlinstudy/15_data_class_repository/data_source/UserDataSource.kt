package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.User

interface UserDataSource {
    suspend fun getUsers(): List<User>
}