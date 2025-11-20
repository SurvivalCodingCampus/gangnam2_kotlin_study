package com.luca.kotlinstudy._15_model_repository.dataSource.todo
import com.luca.kotlinstudy._15_model_repository.model.Todo
import kotlinx.serialization.json.Json
import java.io.File

class FileTodoDatasourceImpl (
    private val filePath: String
    ) : TodoDatasource {
        override suspend fun getTodos(userId: Int): List<Todo> {
            val jsonText = File(filePath).readText()
            val all: List<Todo> = Json.decodeFromString(jsonText)
            val todos = all.filter { it.userId == userId }
            return todos
        }
    }