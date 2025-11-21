package com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.model

import kotlinx.serialization.Serializable

@Serializable
data class Album (
    val userId: Int,
    val id: Int,
    val title: String
)