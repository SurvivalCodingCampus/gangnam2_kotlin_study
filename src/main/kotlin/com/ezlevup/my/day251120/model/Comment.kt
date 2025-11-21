package com.ezlevup.my.day251120.model

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
)
