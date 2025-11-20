package com.luca.kotlinstudy._15_model_repository.dataSource.todo

import com.luca.kotlinstudy._15_model_repository.model.Todo

interface TodoDatasource {
    suspend fun getTodos(userId: Int): List<Todo>
}