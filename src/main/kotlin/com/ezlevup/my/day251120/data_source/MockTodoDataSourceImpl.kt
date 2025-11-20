package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Todo

class MockTodoDataSourceImpl(
    private val todos: List<Todo> = emptyList()
) : TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        return todos
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return todos.filter { it.completed }
    }
}