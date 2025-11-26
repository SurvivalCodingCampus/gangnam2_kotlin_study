package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.model

enum class PhotoType(val typename: String) {
    Article("article"),
    Image("image"),
    Video("video"),
    Unknown("unknown")
}