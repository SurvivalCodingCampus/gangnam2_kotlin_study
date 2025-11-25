package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.model

import kotlinx.datetime.LocalDate

data class Photo(
    val id: Int,
    val type: PhotoType,
    val url: String,
    val title: String,
    val caption: String,
    val content: String,
    val createdAt: LocalDate
)
