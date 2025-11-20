package com.survivalcoding.kotlinstudy.`14_data_source`.practice.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.practice.model.User
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.File

class UserDataSourceImpl(
    val file: File
) : UserDataSource {
    override suspend fun getUsers(): List<User> {
        return Json.decodeFromString(file.readText())
    }
}

fun main(): Unit = runBlocking {
    val file = File("users.json")
    val userData = UserDataSourceImpl(file)

    userData.getUsers().forEach {
        println(it)
    }
}