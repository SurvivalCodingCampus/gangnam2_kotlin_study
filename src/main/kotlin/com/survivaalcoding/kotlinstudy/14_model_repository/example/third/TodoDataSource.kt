package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.third

interface TodoDataSource {
    suspend fun getTodo(): List<Todo>
}
