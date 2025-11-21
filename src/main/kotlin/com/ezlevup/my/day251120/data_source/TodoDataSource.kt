package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}