package com.sesac.practice.day14.todo

class MockTodoDataSourceImpl() : TodoDataSource {

    override suspend fun getTodos(): List<Todo> {
        return listOf(
            Todo(1, 1, "title1", true),
            Todo(2, 2, "title2", false),
            Todo(3, 3, "title3", true),
        )
    }
}
