package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.Todo

interface TodoDataSource {
    // 연습문제 1
    suspend fun getTodo(): Todo

    // 연습문제 2
    suspend fun getTodos(): List<Todo>
}
