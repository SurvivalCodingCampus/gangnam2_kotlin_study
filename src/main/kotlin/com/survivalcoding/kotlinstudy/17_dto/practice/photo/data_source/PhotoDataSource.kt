package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.data_source

import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotos(): List<PhotoDto>
    suspend fun getPhoto(id: Int): PhotoDto
}