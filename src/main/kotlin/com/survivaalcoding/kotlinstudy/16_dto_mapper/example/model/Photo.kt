package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model

import kotlinx.datetime.LocalDate

data class Photo(
    val id: Long,
    val type: PhotoType,
    val title: String,
    val content: String,
    val url: String,
    val caption: String,
    val createdAt: LocalDate
)
