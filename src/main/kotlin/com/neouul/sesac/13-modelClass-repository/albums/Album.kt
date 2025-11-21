package com.neouul.sesac.`13-modelClass-repository`.albums

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val userId: Int,
    val id: Int,
    val title: String,
)