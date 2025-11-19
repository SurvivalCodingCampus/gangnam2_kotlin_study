package com.luca.kotlinstudy._14_dataSource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class TodoList(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
)

@Serializable
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo,
)

@Serializable
data class Geo(
    val lat: String,
    val lng: String,
)

@Serializable
data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String,
)

interface TodoListDataSource {
    suspend fun getTodos(): List<TodoList>
}

class TodoListDataSourceImpl(
    private val filePath: String
) : TodoListDataSource {
    override suspend fun getTodos(): List<TodoList> = withContext(Dispatchers.IO) {
        val jsonString = File(filePath).readText()
        Json.decodeFromString<List<TodoList>>(jsonString)
    }
}

fun main(): Unit = runBlocking {
    val dataSource: TodoListDataSource = TodoListDataSourceImpl(
        "src/main/kotlin/com/luca/kotlinstudy/_14_dataSource/todoList.json"
    )
    val todo = dataSource.getTodos()
    println(todo)
}