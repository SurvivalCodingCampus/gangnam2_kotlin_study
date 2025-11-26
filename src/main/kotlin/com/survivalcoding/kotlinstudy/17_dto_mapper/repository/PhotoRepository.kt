package com.survivalcoding.kotlinstudy.`17_dto_mapper`.repository

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}