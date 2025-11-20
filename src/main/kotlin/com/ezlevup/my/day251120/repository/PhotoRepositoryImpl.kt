package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.data_source.PhotoDataSource
import com.ezlevup.my.day251120.model.Photo

class PhotoRepositoryImpl(
    val photoDataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return photoDataSource.getPhotos(albumId)
    }
}