package com.survival.kotlinstudy.day17.repository

import com.survival.kotlinstudy.day17.datasource.PhotoDataSource
import com.survival.kotlinstudy.day17.mapper.toModel
import com.survival.kotlinstudy.day17.model.Photo

class PhotoRepositoryImpl(
    private val datasource: PhotoDataSource
) : PhotoRepository {

    override suspend fun getPhotos(): List<Photo> {
        return datasource.getPhotos().map {
            it.toModel()
        }
    }

}