package com.neouul.sesac.`15-dto-mapper`.photos.dto

import kotlinx.serialization.Serializable

@Serializable
data class PhotoDTO(
    val id: String? = null,
    val type: String? = null,
    val url: String? = null,
    val title: String? = null,
    val content: String? = null,
    val caption: String? = null,
    val created_at: String? = null,
)
