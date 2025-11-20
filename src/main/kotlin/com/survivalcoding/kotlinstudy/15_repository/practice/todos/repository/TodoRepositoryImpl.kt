package com.survivalcoding.kotlinstudy.`15_repository`.practice.todos.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.todos.data_source.TodoDataSource
import com.survivalcoding.kotlinstudy.`15_repository`.practice.todos.model.Todo

class TodoRepositoryImpl(
    private val dataSource: TodoDataSource
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return dataSource.getTodosFileData()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return getTodos().filter { it.completed }
    }
}