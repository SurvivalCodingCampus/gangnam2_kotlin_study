package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}