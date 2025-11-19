package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.Todo
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val json = File("src/main/resources/14_data_source/todo.json").readText()

        return Json.decodeFromString<Todo>(json)
    }
}
