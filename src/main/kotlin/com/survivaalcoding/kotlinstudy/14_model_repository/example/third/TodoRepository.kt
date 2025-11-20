package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.third

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}