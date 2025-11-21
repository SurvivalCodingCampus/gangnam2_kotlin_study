package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.User

interface UserDataSource {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}