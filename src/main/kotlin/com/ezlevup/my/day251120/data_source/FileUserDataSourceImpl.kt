package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.User
import kotlinx.serialization.json.Json
import java.io.File

class FileUserDataSourceImpl(
    val fileName: String = "users.json",
) : UserDataSource {
    override suspend fun getUsers(): List<User> {
        val file = File(fileName)
        val json = file.readText()
        return Json.decodeFromString<List<User>>(json)
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return getUsers().sortedBy { it.username }.drop(10)
    }
}
