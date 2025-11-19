package com.ezlevup.my.day251119.exercise

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File


@Serializable
data class Todo(
    var userId: Long,
    var id: Long,
    var title: String,
    var completed: Boolean,
)

interface TodoDataSource {
    suspend fun getTodo(): Todo
}

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val file = File("todo.json")
        val json = file.readText()
        return Json.decodeFromString<Todo>(json)
    }
}

fun main(): Unit = runBlocking {
    val todoDataSource = TodoDataSourceImpl()
    val todo = todoDataSource.getTodo()
    println(todo)
}



