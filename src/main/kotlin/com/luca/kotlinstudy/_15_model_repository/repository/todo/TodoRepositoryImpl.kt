package com.luca.kotlinstudy._15_model_repository.repository.todo

import com.luca.kotlinstudy._15_model_repository.dataSource.todo.TodoDatasource
import com.luca.kotlinstudy._15_model_repository.model.Todo

class TodoRepositoryImpl(
    private val dataSource: TodoDatasource
) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        return dataSource.getTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return dataSource.getTodos().filter { it.completed }
    }
}