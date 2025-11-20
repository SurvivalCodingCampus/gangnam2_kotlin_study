package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Todo
import kotlinx.serialization.json.Json
import java.io.File

class FileTodoDataSourceImpl(
    val fileName: String = "todos.json",
) : TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        val file = File(fileName)
        val json = file.readText()
        return Json.decodeFromString<List<Todo>>(json)
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return getTodos().filter { it.completed }
    }
}