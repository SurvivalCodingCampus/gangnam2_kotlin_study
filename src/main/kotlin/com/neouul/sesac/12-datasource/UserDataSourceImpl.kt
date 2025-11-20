package com.neouul.sesac.`12-datasource`

import kotlinx.serialization.json.Json
import java.io.File

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> {
        val file = File("docs/data_source/users.json")
        val json = file.readText()

        return Json.decodeFromString(json)
    }
}