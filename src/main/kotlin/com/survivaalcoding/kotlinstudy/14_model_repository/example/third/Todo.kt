package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.third

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)
