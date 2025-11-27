package com.luca.kotlinstudy._17_dto.model

import java.time.LocalDate

class Photo(
    val id: Long,
    val type: PhotoType,
    val title: String?,
    val content: String?,
    val url: String?,
    val caption: String?,
    val createdAt: LocalDate,
)