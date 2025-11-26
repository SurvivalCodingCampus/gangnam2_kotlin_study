package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.repository

import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.data_source.PhotoDataSource
import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.mapper.toPhoto
import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.model.Photo

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        return dataSource.getPhotos().map { it.toPhoto() }
    }

    override suspend fun getPhoto(id: Int): Photo {
        return dataSource.getPhoto(id).toPhoto()
    }
}