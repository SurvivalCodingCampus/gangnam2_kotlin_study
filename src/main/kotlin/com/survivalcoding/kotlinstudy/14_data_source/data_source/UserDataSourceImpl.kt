package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.User
import kotlinx.serialization.json.Json
import java.io.File

class UserDataSourceImpl : UserDataSource {
    // 연습문제 3
    override suspend fun getUsers(): List<User> {
        val json = File("src/main/resources/14_data_source/users.json").readText()

        return Json.decodeFromString<List<User>>(json)
    }
}