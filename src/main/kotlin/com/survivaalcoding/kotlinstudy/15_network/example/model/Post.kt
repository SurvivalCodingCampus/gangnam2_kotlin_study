package com.survivaalcoding.kotlinstudy.`15_network`.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Long? = null,
    val title: String,
    val body: String,
    val userId: Long
)