package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fifth

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val id: Long,
    val userId: Long,
    val title: String,
)
