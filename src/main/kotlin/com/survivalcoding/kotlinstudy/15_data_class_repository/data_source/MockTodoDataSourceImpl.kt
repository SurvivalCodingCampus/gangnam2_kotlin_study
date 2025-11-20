package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Todo
import com.survivalcoding.kotlinstudy.common.readJsonFile

class MockTodoDataSourceImpl() : TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        return readJsonFile("src/main/resources/15_model_class_repository/todos.json")
    }
}