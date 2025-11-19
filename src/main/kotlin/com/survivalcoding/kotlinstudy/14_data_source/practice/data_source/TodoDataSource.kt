package com.survivalcoding.kotlinstudy.`14_data_source`.practice.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.practice.model.Todo

interface TodoDataSource {
    suspend fun getTodo(): Todo
    suspend fun getTodos(): List<Todo>
}