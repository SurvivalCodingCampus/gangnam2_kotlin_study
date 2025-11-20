package com.survivalcoding.kotlinstudy.`15_repository`.practice.todos.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.todos.model.Todo
import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl(
    private val file: File
) : TodoDataSource {
    override suspend fun getTodosFileData(): List<Todo> {
        return Json.decodeFromString(file.readText())
    }
}