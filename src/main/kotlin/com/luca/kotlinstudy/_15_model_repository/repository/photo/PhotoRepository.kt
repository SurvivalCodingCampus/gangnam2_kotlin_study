package com.luca.kotlinstudy._15_model_repository.repository.photo

import com.luca.kotlinstudy._15_model_repository.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}