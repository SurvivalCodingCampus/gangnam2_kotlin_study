package com.survivalcoding.kotlinstudy.`14_data_source`.practice.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.practice.model.User

interface UserDataSource {
    suspend fun getUsers(): List<User>
}