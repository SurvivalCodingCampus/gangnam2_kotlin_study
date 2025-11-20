package com.luca.kotlinstudy._15_model_repository.dataSource.todo

import com.luca.kotlinstudy._15_model_repository.model.Todo

class MockTodoDatasourceImpl : TodoDatasource {
    override suspend fun getTodos(userId: Int): List<Todo> {
        val all = listOf(
            Todo(1, 1, "Mock todo 1", true),
            Todo(1, 2, "Mock todo 2", true),
            Todo(2, 3, "Mock todo 3", false),
        )
        val todos = all.filter { it.userId == userId }
        return todos
    }
}
