package com.survivalcoding.kotlinstudy.`14_data_source`.practice.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.practice.model.Todo
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl(
    val file: File
) : TodoDataSource {
    override suspend fun getTodo(): Todo {
        return Json.decodeFromString(file.readText())
    }

    override suspend fun getTodos(): List<Todo> {
        return Json.decodeFromString(file.readText())
    }
}

fun main(): Unit = runBlocking {
    val file1 = File("todo.json")
    val todoData1 = TodoDataSourceImpl(file1).getTodo()

    val file2 = File("todos.json")
    val todoData2 = TodoDataSourceImpl(file2).getTodos()

    println(todoData1)
    println(todoData2)
}