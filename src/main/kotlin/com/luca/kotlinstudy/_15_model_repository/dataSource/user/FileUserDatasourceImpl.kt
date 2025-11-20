package com.luca.kotlinstudy._15_model_repository.dataSource.user

import com.luca.kotlinstudy._15_model_repository.model.User
import kotlinx.serialization.json.Json
import java.io.File

class FileUserDatasourceImpl(
    private val filePath: String,
) : UserDatasource {
    override suspend fun getUsers(): List<User> {
        val jsonText = File(filePath).readText()
        val users: List<User> = Json.decodeFromString(jsonText)
        return users
    }
}