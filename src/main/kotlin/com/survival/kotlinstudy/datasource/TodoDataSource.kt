package com.survival.kotlinstudy.datasource

interface TodoDataSource {

    suspend fun getTodo(): Todo

    suspend fun getTodos(): List<Todo>
}