package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.repository

import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
    suspend fun getPhoto(id: Int): Photo
}