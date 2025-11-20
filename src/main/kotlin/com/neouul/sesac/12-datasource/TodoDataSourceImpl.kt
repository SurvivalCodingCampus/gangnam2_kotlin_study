package com.neouul.sesac.`12-datasource`

import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val file = File("docs/data_source/todo.json")
        val json = file.readText()

        return Json.decodeFromString(json)
    }

    override suspend fun getTodos(): List<Todo> {
        val file = File("docs/data_source/todos.json")
        val json = file.readText()

        return Json.decodeFromString(json)
    }

    override suspend fun getUsers(): List<User> {
        val file = File("docs/data_source/users.json")
        val json = file.readText()

        return Json.decodeFromString(json)
    }
}