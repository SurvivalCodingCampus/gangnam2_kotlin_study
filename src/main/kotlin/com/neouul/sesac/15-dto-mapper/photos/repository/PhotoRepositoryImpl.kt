package com.neouul.sesac.`15-dto-mapper`.photos.repository

import com.neouul.sesac.`15-dto-mapper`.photos.data_source.MockPhotoDataSourceImpl
import com.neouul.sesac.`15-dto-mapper`.photos.data_source.PhotoDataSource
import com.neouul.sesac.`15-dto-mapper`.photos.mapper.toModel
import com.neouul.sesac.`15-dto-mapper`.photos.model.Photo

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource = MockPhotoDataSourceImpl()
) : PhotoRepository {

    override suspend fun getPhotos(): List<Photo> {
        val response = dataSource.loadPhotos()

        if (response.body != null && response.body.isNotEmpty()) {
            return response.body.map { it?.toModel() as Photo }
        }
        return listOf()
    }
}