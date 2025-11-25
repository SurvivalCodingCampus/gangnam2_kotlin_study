package com.hhp227.kotlinstudy.`16_dto`

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        return dataSource.fetchPhotos().mapNotNull { it.toModel() }
    }
}