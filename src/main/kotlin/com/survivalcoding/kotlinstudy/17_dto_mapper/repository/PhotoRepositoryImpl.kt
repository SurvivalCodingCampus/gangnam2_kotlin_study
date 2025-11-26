package com.survivalcoding.kotlinstudy.`17_dto_mapper`.repository

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source.PhotoDataSource
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.mapper.toModel
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.Photo

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        return dataSource.getPhotos().map { it.toModel() }
    }
}