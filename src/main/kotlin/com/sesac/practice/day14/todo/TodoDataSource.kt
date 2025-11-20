package com.sesac.practice.day14.todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
}
