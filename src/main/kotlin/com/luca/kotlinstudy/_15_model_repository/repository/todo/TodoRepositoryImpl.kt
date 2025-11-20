package com.luca.kotlinstudy._15_model_repository.repository.todo

import com.luca.kotlinstudy._15_model_repository.dataSource.todo.TodoDatasource
import com.luca.kotlinstudy._15_model_repository.model.Todo

class TodoRepositoryImpl(
    private val dataSource: TodoDatasource
) : TodoRepository {
    override suspend fun getTodos(userId: Int): List<Todo> {
        val todos = dataSource.getTodos(userId)
        return todos
    }
}