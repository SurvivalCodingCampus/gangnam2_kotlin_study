package com.sesac.practice.day14.album

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val userId: Long,
    val id: Long,
    val title: String,
)
