package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.repository

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.datasource.PhotoDataSource
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.mapper.toModel
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model.Photo

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        val photos = dataSource.getPhotos().body ?: return emptyList()

        return photos.map { it.toModel() }
    }
}