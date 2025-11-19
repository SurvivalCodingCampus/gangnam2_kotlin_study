package com.luca.kotlinstudy._14_dataSource

import com.luca.kotlinstudy._12_debugging_lambda.loadChartData
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
}

class TodoDataSourceImpl(
    private val filePath: String
) : TodoDataSource {

    override suspend fun getTodo(): Todo = withContext(Dispatchers.IO) {
        val jsonString = File(filePath).readText()
        Json.decodeFromString<Todo>(jsonString)
    }
}

fun main() = runBlocking {
    val dataSource: TodoDataSource = TodoDataSourceImpl(
        "src/main/kotlin/com/luca/kotlinstudy/_14_dataSource/todo.json"
    )
    val todo = dataSource.getTodo()
    println(todo)
}