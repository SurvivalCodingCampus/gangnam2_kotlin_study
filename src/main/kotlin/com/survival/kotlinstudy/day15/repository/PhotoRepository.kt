package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}