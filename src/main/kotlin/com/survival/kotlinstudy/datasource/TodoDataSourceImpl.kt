package com.survival.kotlinstudy.datasource

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val file = File("todo.json")
        return Json.decodeFromString<Todo>(file.readText())
    }
}