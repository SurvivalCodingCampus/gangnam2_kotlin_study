package com.survivalcoding.kotlinstudy.`14_data_source`.model

import kotlinx.serialization.Serializable

// 연습문제 2
@Serializable
data class Todos(
    val todoList: List<Todo>
)
