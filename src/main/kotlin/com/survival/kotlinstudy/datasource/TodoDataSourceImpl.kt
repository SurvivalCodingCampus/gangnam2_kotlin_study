package com.survival.kotlinstudy.datasource

import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val file = File("todo.json")
        return Json.decodeFromString<Todo>(file.readText())
    }

    override suspend fun getTodos(): List<Todo> {
        val file = File("todos.json")
        return Json.decodeFromString(file.readText())
    }
}