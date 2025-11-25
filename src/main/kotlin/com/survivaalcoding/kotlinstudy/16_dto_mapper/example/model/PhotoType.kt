package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model

enum class PhotoType {
    ARTICLE,
    IMAGE,
    VIDEO,
    UNKNOWN;

    companion object {
        fun fromString(type: String?): PhotoType {
            if (type == null) UNKNOWN

            return entries.firstOrNull {
                it.name.equals(type, ignoreCase = true)
            } ?: UNKNOWN
        }
    }
}