package com.luca.kotlinstudy._15_model_repository.repository.photo

import com.luca.kotlinstudy._15_model_repository.dataSource.photo.PhotoDataSource
import com.luca.kotlinstudy._15_model_repository.model.Photo

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getComments(albumId: Int): List<Photo> {
        return dataSource.getComments(albumId)
    }
}