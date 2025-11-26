package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.repository

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}