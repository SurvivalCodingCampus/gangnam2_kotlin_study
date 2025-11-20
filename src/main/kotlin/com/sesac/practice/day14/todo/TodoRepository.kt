package com.sesac.practice.day14.todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}
