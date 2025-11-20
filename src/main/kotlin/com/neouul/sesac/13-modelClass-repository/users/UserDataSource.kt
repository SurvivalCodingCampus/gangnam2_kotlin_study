package com.neouul.sesac.`13-modelClass-repository`.users

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.File

interface UserDataSource {
    suspend fun loadUsers(): List<User>
}

class UserDataSourceImpl(
    private val path: String = "docs/data_source/users.json",
) : UserDataSource {
    override suspend fun loadUsers(): List<User> = withContext(Dispatchers.IO) {
        Json.decodeFromString(File(path).readText())
    }
}