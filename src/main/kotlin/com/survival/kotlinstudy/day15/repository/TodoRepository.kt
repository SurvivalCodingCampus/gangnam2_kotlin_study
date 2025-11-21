package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>

    suspend fun getCompletedTodos(): List<Todo>
}