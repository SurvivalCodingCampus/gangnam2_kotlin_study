package com.luca.kotlinstudy._17_dto.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDTO(
    @SerialName("id")
    val id: Int? = null,

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
