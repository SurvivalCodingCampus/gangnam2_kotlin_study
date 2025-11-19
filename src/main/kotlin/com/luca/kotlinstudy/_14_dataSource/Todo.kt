package com.luca.kotlinstudy._14_dataSource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

interface TodoDataSource {
    suspend fun getTodo(): Todo
    suspend fun getTodos(): List<Todo>
}

class TodoDataSourceImpl(
    private val filePath: String
) : TodoDataSource {

    override suspend fun getTodo(): Todo = withContext(Dispatchers.IO) {
        val jsonString = File(filePath).readText()
        Json.decodeFromString<Todo>(jsonString)
    }

    override suspend fun getTodos(): List<Todo> = withContext(Dispatchers.IO) {
        val jsonString = File(filePath).readText()
        Json.decodeFromString<List<Todo>>(jsonString)
    }
}

fun main() = runBlocking {
    val dataSourceTodo: TodoDataSource = TodoDataSourceImpl(
        "src/main/kotlin/com/luca/kotlinstudy/_14_dataSource/todo.json"
    )
    val dataSourceTodos: TodoDataSource = TodoDataSourceImpl(
        "src/main/kotlin/com/luca/kotlinstudy/_14_dataSource/todos.json"
    )
    val todo = dataSourceTodo.getTodo()
    val todos = dataSourceTodos.getTodos()
    println(todo)
    println(todos)
}