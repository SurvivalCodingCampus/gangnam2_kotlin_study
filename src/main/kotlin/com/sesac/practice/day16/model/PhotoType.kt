package com.sesac.practice.day16.model

import com.sesac.practice.day16.model.PhotoType.*

enum class PhotoType {
    ARTICLE, IMAGE, VIDEO, UNKNOWN
}

fun String?.toPhotoType(): PhotoType =
    when (this?.lowercase()?.trim()) {
        "article" -> ARTICLE
        "image" -> IMAGE
        "video" -> VIDEO
        else -> UNKNOWN
    }
