package com.survival.kotlinstudy.datasource

import kotlinx.serialization.json.Json
import java.io.File

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> {
        val file = File("user.json")

        val data = Json.decodeFromString<List<User>>(file.readText())
        return data
    }
}