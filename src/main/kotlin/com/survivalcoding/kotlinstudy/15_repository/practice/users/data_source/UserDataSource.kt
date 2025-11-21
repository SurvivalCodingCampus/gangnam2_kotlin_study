package com.survivalcoding.kotlinstudy.`15_repository`.practice.users.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.model.User

interface UserDataSource {
    suspend fun getUsersFileData(): List<User>
}