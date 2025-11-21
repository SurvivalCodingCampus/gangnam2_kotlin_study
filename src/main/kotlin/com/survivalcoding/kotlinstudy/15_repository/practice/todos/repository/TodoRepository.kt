package com.survivalcoding.kotlinstudy.`15_repository`.practice.todos.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.todos.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}