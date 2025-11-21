package com.ezlevup.my.day251121

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getTodo(id: Int): Todo
    suspend fun postTodo(newTodo: Todo): Todo
}
