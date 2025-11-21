package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.User
import kotlinx.serialization.json.Json
import java.io.File

class FileUserDataSourceImpl(
    private val filePath: String
) : UserDataSource {

    override suspend fun getUsers(): List<User> {
        val file = File(filePath)
        return Json.decodeFromString(file.readText())
    }
}