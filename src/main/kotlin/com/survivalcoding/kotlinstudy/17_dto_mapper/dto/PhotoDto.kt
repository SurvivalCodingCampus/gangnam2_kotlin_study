package com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDto(
    @SerialName("id")
    val id: Int,

    @SerialName("type")
    val type: String? = null,

    @SerialName("title")
    val title: String? = null,

    @SerialName("content")
    val content: String? = null,

    @SerialName("url")
    val url: String? = null,

    @SerialName("caption")
    val caption: String? = null,

    @SerialName("created_at")
    val createdAt: String? = null
)
