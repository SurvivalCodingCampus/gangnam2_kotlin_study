package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Photo

interface PhotoDataSource {
    suspend fun getPhotos(albumId: Int): List<Photo>
}