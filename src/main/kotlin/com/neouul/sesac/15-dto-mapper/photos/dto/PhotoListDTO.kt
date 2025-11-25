package com.neouul.sesac.`15-dto-mapper`.photos.dto

import kotlinx.serialization.Serializable

@Serializable
data class PhotoListDTO(
    val photos: List<PhotoDTO?>?
)