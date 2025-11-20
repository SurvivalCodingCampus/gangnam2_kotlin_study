package com.survival.kotlinstudy.day15.model

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)
