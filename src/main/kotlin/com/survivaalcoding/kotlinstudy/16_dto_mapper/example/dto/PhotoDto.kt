package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDto(
    val id: Long? = 0,
    val type: String? = null,
    val title: String? = null,
    val content: String? = null,
    val url: String? = null,
    val caption: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null
)
