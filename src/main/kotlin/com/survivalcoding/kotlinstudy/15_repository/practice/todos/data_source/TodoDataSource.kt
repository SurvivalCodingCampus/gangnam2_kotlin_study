package com.survivalcoding.kotlinstudy.`15_repository`.practice.todos.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.todos.model.Todo

interface TodoDataSource {
    suspend fun getTodosFileData(): List<Todo>
}