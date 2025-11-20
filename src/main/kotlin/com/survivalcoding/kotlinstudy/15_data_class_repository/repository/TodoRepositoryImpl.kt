package com.survivalcoding.kotlinstudy.`15_data_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source.TodoDataSource
import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Todo

class TodoRepositoryImpl(
    private val dataSource: TodoDataSource
) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        return dataSource.getTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return getTodos()
            .filter { it.completed }
    }
}