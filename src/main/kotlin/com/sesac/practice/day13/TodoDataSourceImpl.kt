package com.sesac.practice.day13

import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl(
    val filename: String,
) : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val file = File(filename)
        val json = file.readText()

        return Json.decodeFromString(json)
    }
}
