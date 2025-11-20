package com.luca.kotlinstudy._15_model_repository.model

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val userId: Int,
    val id: Int,
    val title: String,
)