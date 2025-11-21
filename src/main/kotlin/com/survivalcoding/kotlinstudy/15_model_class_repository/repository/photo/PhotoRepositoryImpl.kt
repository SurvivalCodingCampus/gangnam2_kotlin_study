package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository.photo

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.photo.PhotoDataSource
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Photo

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return dataSource.getPhotos()
            .filter { it.albumId == albumId }
    }
}