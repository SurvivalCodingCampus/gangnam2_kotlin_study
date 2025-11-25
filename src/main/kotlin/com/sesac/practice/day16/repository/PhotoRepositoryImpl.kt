package com.sesac.practice.day16.repository

import com.sesac.practice.day16.datasource.PhotoDataSource
import com.sesac.practice.day16.mapper.toModel
import com.sesac.practice.day16.model.Photo

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource,
) : PhotoRepository {

    override suspend fun getPhotos(): List<Photo> {
        val response = dataSource.getPhotos()

        val photoDtos = response.body ?: emptyList()

        return photoDtos.map { it.toModel() }
    }
}
