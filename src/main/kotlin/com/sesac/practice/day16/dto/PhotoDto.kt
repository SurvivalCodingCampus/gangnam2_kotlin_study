package com.sesac.practice.day16.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDto(
    val id: Long? = null,
    val type: String? = null,
    @SerialName("created_at") val createdAt: String? = null,
    val title: String? = null,
    val content: String? = null,
    val url: String? = null,
    val caption: String? = null,
)
