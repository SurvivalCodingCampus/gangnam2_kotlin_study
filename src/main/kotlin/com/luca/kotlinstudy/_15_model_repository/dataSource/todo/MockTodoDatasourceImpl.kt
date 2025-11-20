package com.luca.kotlinstudy._15_model_repository.dataSource.todo

import com.luca.kotlinstudy._15_model_repository.model.Todo

class MockTodoDatasourceImpl : TodoDatasource {
    override suspend fun getTodos(): List<Todo> {
        return listOf(
            Todo(1, 1, "Mock todo 1", true),
            Todo(1, 2, "Mock todo 2", true),
            Todo(2, 3, "Mock todo 3", false),
        )
    }
}
