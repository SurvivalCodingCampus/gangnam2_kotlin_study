package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: Long,
    val postId: Long,
    val name: String,
    val email: String,
    val body: String
)
