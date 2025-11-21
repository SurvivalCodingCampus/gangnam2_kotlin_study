package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val id: Long,
    val albumId: Long,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)