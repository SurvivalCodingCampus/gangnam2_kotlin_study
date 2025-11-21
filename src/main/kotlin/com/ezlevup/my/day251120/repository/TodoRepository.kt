package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}