package com.neouul.sesac.`13-modelClass-repository`.todos

import kotlinx.serialization.json.Json
import java.io.File

interface TodoDataSource {
    suspend fun jsonToTodos(): List<Todo>
}

class TodoDataSourceImpl(
    private val path: String = "docs/data_source/todos.json",
) : TodoDataSource {
    override suspend fun jsonToTodos(): List<Todo> {
        val json = File(path).readText()
        return Json.decodeFromString(json)
    }
}