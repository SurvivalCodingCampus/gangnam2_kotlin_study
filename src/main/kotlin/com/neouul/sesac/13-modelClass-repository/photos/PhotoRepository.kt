package com.neouul.sesac.`13-modelClass-repository`.photos

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource,
) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return dataSource.loadPhotos().filter { it.albumId == albumId }
    }
}