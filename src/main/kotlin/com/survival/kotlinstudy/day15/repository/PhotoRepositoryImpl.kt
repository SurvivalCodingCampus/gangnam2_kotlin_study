package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.PhotoDataSource
import com.survival.kotlinstudy.day15.model.Photo

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return dataSource.getPhotos().filter { it.albumId == albumId }
    }

}