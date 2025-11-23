package com.luca.kotlinstudy._16_http.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Int? = null,
    val title: String,
    val body: String,
    val userId: Int
)