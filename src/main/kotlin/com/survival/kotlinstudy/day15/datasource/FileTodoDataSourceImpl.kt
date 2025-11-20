package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Todo
import kotlinx.serialization.json.Json
import java.io.File

class FileTodoDataSourceImpl(
    private val filePath: String
) : TodoDataSource {

    override suspend fun getTodos(): List<Todo> {
        val file = File(filePath)
        return Json.decodeFromString(file.readText())
    }
}