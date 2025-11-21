package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.data_source.TodoDataSource
import com.ezlevup.my.day251120.model.Todo

class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return todoDataSource.getTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return todoDataSource.getCompletedTodos()
    }
}
