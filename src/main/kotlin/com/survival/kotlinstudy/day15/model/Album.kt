package com.survival.kotlinstudy.day15.model

import kotlinx.serialization.Serializable


@Serializable
data class Album(
    val userId: Int,
    val id: Int,
    val title: String,
)
