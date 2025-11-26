package com.survival.kotlinstudy.day17.repository

import com.survival.kotlinstudy.day17.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}