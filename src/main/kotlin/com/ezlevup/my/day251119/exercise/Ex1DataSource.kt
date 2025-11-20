package com.ezlevup.my.day251119.exercise

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File


@Serializable
data class Todo(
    var userId: Long? = 0,
    var id: Long? = 0,
    var title: String? = null,
    var completed: Boolean? = false,
)

interface TodoDataSource {
    suspend fun getTodo(): Todo
    suspend fun getTodos(): List<Todo>
}

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val file = File("todo.json")
        val json = file.readText()
        return Json.decodeFromString<Todo>(json)
    }

    override suspend fun getTodos(): List<Todo> {
        val file = File("todo_ex2.json")
        val json = file.readText()
        return Json.decodeFromString<List<Todo>>(json)
    }
}

fun main(): Unit = runBlocking {
    val todoDataSource = TodoDataSourceImpl()

    // val todo = todoDataSource.getTodo()
    // println(todo)

    val todos = todoDataSource.getTodos()
    todos.take(5).forEach { println(it) }
    println(todos.count())

    // 불량 데이터 확인
    todos.filter { it -> it.userId == 0L || it.id == 0L || it.title.isNullOrEmpty() }
        .forEach { println(it) }
}



