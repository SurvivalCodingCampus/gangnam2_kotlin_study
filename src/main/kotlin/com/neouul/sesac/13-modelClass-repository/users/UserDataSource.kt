package com.neouul.sesac.`13-modelClass-repository`.users

import kotlinx.serialization.json.Json
import java.io.File

interface UserDataSource {
    suspend fun jsonToUsers(): List<User>
}

class UserDataSourceImpl(
    private val path: String = "docs/data_source/users.json",
) : UserDataSource {
    override suspend fun jsonToUsers(): List<User> {
        val json = File(path).readText()
        return Json.decodeFromString(json)
    }
}