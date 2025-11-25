package com.sesac.practice.day16.model

enum class PhotoType {
    ARTICLE, IMAGE, VIDEO, UNKNOWN;

    companion object {
        fun parse(type: String?): PhotoType =
            when (type?.lowercase()) {
                "article" -> ARTICLE
                "image" -> IMAGE
                "video" -> VIDEO
                else -> UNKNOWN
            }
    }
}
