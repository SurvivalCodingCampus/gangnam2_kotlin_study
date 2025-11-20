package com.survivalcoding.kotlinstudy.`15_data_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}