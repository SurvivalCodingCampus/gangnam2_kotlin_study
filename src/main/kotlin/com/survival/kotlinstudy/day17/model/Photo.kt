package com.survival.kotlinstudy.day17.model

import kotlinx.serialization.SerialName
import java.time.LocalDate

data class Photo(
    val id: Int,
    val type: PhotoType,
    val title: String,
    val url: String,
    val content: String,
    val caption: String,
    @SerialName("created_at")
    val createdAt: LocalDate?
)


enum class PhotoType {
    ARTICLE, IMAGE, VIDEO, UNKNOWN
}
