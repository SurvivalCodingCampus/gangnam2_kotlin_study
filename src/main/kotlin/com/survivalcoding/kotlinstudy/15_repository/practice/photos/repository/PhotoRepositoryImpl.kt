package com.survivalcoding.kotlinstudy.`15_repository`.practice.photos.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.photos.data_source.PhotoDataSource
import com.survivalcoding.kotlinstudy.`15_repository`.practice.photos.model.Photo

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
): PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        val photoSource = dataSource.getPhotosFileData()
        return photoSource.filter { it.albumId == albumId }
    }
}