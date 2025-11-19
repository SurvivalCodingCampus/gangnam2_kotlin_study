package com.sesac.practice.day13

interface TodoDataSource {
    suspend fun getTodo(): Todo
    suspend fun getTodos(): List<Todo>
}
