package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.todo

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
}