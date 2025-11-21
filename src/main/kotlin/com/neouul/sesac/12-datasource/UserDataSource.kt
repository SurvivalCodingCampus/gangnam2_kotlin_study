package com.neouul.sesac.`12-datasource`

interface UserDataSource {
    suspend fun getUsers(): List<User>
}