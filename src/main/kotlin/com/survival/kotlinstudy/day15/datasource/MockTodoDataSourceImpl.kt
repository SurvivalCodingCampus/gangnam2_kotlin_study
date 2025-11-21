package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Todo
import kotlinx.serialization.json.Json

class MockTodoDataSourceImpl(
    private val text: String
) : TodoDataSource {

    override suspend fun getTodos(): List<Todo> {
        return Json.decodeFromString(text)
    }
}