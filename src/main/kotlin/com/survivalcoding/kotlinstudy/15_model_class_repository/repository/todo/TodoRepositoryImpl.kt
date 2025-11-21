package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository.todo

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.todo.TodoDataSource
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Todo

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