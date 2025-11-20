package com.neouul.sesac.`12-datasource`

interface TodoDataSource {
    suspend fun getTodo(): Todo

    suspend fun getTodos(): List<Todo>

    suspend fun getUsers(): List<User>
}