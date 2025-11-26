package com.survivalcoding.kotlinstudy.`15_dto`.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// DataSource
@Serializable
data class PostDto(
    @SerialName("body")
    val body: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("userId")
    val userId: Int? = null
)