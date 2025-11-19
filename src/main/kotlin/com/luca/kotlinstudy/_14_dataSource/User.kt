package com.luca.kotlinstudy._14_dataSource

import com.luca.kotlinstudy._14_dataSource.TodoListDataSourceImpl.Companion.usersFilePath
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class User(
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

interface UserDataSource {
    suspend fun getUsers(): List<User>
}

class TodoListDataSourceImpl(
    private val filePath: String
) : UserDataSource {
    override suspend fun getUsers(): List<User> = withContext(Dispatchers.IO) {
        val jsonString = File(filePath).readText()
        Json.decodeFromString<List<User>>(jsonString)
    }

    companion object {
        val usersFilePath = "src/main/kotlin/com/luca/kotlinstudy/_14_dataSource/users.json"
    }
}

fun main(): Unit = runBlocking {
    val dataSource: UserDataSource = TodoListDataSourceImpl(usersFilePath)
    val todo = dataSource.getUsers()
    println(todo)
}