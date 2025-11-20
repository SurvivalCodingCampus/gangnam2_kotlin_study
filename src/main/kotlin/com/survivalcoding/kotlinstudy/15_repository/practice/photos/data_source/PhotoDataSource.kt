package com.survivalcoding.kotlinstudy.`15_repository`.practice.photos.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.photos.model.Photo

interface PhotoDataSource {
    suspend fun getPhotosFileData(): List<Photo>
}