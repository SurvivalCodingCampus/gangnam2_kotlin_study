package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.TodoDataSource
import com.survival.kotlinstudy.day15.model.Todo

class TodoRepositoryImpl(
    private val dataSource: TodoDataSource
) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        return dataSource.getTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return dataSource.getTodos().filter { it.completed }
    }

}