package com.sesac.practice.day16.model

import java.time.LocalDate

data class Photo(
    val id: Long,
    val type: PhotoType,
    val createdAt: LocalDate?,
    val title: String,
    val content: String,
    val url: String?,
    val caption: String,
)
