package com.survivalcoding.kotlinstudy.`15_model_class_repository`.model

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)
