package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Todo
import kotlinx.serialization.json.Json
import java.io.File

class MockTodoDataSourceImpl() : TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        val json = File("src/main/resources/15_model_class_repository/todos.json").readText()

        return Json.decodeFromString(json)
    }
}