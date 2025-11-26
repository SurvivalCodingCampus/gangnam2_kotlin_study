package com.sesac.practice.day16.core

import com.sesac.practice.day16.model.PhotoType
import com.sesac.practice.day16.model.PhotoType.*
import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter.ofPattern

fun String?.toPhotoType(): PhotoType =
    when (this?.lowercase()?.trim()) {
        "article" -> ARTICLE
        "image" -> IMAGE
        "video" -> VIDEO
        else -> UNKNOWN
    }

fun String?.toLocalDateTime(): LocalDateTime? = this?.let {
    try {
        LocalDateTime.parse(this, ofPattern("yyyy/MM/dd HH:mm:ss"))
    } catch (_: DateTimeException) {
        null
    }
}

fun String?.toLocalDate(): LocalDate? = this?.let {
    try {
        LocalDate.parse(this, ofPattern("yyyy-MM-dd"))
    } catch (_: DateTimeException) {
        null
    }
}
