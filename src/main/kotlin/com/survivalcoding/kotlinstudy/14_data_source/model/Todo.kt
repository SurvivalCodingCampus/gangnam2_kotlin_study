package com.survivalcoding.kotlinstudy.`14_data_source`.model

import kotlinx.serialization.Serializable

@Serializable
data class Todo (
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)