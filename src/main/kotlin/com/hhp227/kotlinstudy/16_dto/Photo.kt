package com.hhp227.kotlinstudy.`16_dto`

import java.time.LocalDate

data class Photo(
    val id: String,
    val type: PhotoType,
    val title: String?,
    val content: String?,
    val url: String?,
    val caption: String?,
    val createdAt: LocalDate
)