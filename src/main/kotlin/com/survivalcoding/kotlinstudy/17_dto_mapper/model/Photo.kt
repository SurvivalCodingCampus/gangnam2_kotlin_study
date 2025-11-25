package com.survivalcoding.kotlinstudy.`17_dto_mapper`.model

import java.time.LocalDate

data class Photo(
    val id: Int?,
    val type: PhotoType?,
    val title: String?,
    val content: String?,
    val url: String?,
    val caption: String?,
    val createdAt: LocalDate?,
)