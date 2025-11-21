package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.third

import kotlinx.serialization.json.Json
import java.io.File

class FileTodoDataSourceImpl(val file: File) : TodoDataSource {
    override suspend fun getTodo(): List<Todo> {
        val readText = file.readText()

        return Json.decodeFromString(readText)
    }
}