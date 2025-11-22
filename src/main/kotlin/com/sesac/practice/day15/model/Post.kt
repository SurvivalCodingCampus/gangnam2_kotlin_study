package com.sesac.practice.day15.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String,
)
