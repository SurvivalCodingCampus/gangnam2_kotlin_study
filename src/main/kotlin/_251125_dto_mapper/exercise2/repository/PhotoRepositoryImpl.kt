package _251125_dto_mapper.exercise2.repository

import _251125_dto_mapper.exercise2.data_source.PhotoDataSourceImpl
import _251125_dto_mapper.exercise2.mapper.toModel
import _251125_dto_mapper.exercise2.model.Photo

class PhotoRepositoryImpl(
    private val photoDataSourceImpl: PhotoDataSourceImpl
) : PhotoRepository {
    override suspend fun getAllPhotos(): List<Photo> {
        return photoDataSourceImpl.getAllPhoto().body.map { it.toModel() }
    }
}