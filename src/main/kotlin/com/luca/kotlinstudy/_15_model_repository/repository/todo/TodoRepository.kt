package com.luca.kotlinstudy._15_model_repository.repository.todo

import com.luca.kotlinstudy._15_model_repository.model.Todo


interface TodoRepository {
    suspend fun getTodos(userId: Int): List<Todo>
}