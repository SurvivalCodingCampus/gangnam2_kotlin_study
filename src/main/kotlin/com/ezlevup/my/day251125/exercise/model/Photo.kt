package com.ezlevup.my.day251125.exercise.model

import com.ezlevup.my.day251125.exercise.mapper.PhotoType
import java.time.LocalDate

data class Photo(
    val caption: String,
    val content: String,
    val createdAt: LocalDate,
    val id: Int,
    val title: String,
    val type: PhotoType,
    val url: String,
)
