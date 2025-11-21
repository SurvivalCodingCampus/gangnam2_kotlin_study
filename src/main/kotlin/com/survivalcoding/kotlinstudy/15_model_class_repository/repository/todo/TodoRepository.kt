package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository.todo

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}