package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
}