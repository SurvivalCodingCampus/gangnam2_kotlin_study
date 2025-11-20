package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.User

interface UserDataSource {
    // 연습문제 3
    suspend fun getUsers(): List<User>
}
