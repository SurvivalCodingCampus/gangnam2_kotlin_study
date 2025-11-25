package com.sesac.kotlinstudy.day16.dto

import kotlinx.serialization.Serializable

// DataSource
@Serializable
data class PostDto(
    val body: String? = null,
    val id: Int? = null,
    val title: String? = null,
    val userId: Int? = null,
)
