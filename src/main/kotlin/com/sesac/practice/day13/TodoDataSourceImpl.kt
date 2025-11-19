package com.sesac.practice.day13

import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl(
    val filename: String,
) : TodoDataSource {
    override suspend fun getTodo(): Todo {
        return decodeFromFile(filename)
    }

    override suspend fun getTodos(): List<Todo> {
        return decodeFromFile(filename)
    }

    private inline fun <reified T> decodeFromFile(filename: String): T {
        val file = File(filename)
        val json = file.readText()

        return Json.decodeFromString(json)
    }
}
