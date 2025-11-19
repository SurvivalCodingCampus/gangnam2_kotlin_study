package com.neouul.sesac.`12-datasource`

import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val file = File("docs/file/todo.json")
        val json = file.readText()

        return Json.decodeFromString(json)
    }
}