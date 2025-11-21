package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository.photo

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}