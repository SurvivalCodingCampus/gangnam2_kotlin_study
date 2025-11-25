package com.neouul.sesac.`15-dto-mapper`.photos.model

import java.time.LocalDate

data class Photo(
    val id: Int,
    val type: Type,
    val url: String,
    val title: String,
    val content: String,
    val caption: String,
    val created_at: LocalDate,
)

enum class Type {
    ARTICLE, IMAGE, VIDEO, UNKNOWN
}
