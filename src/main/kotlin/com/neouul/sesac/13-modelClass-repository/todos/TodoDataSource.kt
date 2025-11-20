package com.neouul.sesac.`13-modelClass-repository`.todos

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.File

interface TodoDataSource {
    suspend fun loadTodos(): List<Todo>
}

class TodoDataSourceImpl(
    private val path: String = "docs/data_source/todos.json",
) : TodoDataSource {
    override suspend fun loadTodos(): List<Todo> = withContext(Dispatchers.IO) {
        Json.decodeFromString(File(path).readText())
    }
}