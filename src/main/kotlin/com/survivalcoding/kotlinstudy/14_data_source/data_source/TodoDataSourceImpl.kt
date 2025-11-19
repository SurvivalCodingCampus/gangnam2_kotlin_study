package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.Todo
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl : TodoDataSource {
    // 연습문제 1
    override suspend fun getTodo(): Todo {
        val json = File("src/main/resources/14_data_source/todo.json").readText()

        return Json.decodeFromString<Todo>(json)
    }

    // 연습문제 2
    override suspend fun getTodos(): List<Todo> {
        val json = File("src/main/resources/14_data_source/todos.json").readText()

        return Json.decodeFromString<List<Todo>>(json)
    }
}
