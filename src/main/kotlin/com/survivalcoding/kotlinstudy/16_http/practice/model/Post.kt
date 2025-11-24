package com.survivalcoding.kotlinstudy.`16_http`.practice.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val userId: Int? = null,
    val id: Int? = null,
    val title: String? = null,
    val body: String? = null,
)
