package com.survivalcoding.kotlinstudy.`15_repository`.practice.photos.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.photos.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}