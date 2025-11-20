package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fourth

import kotlinx.serialization.json.Json
import java.io.File

class FileUserDataSourceImpl(val file: File) : UserDataSource {
    override suspend fun getUser(): List<User> {
        val readText = file.readText()

        return Json.decodeFromString(readText)
    }
}