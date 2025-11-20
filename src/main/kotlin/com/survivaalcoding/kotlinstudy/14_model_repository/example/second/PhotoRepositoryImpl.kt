package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

class PhotoRepositoryImpl(val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(albumId: Long): List<Photo> {
        val photos = dataSource.getPhoto()

        return photos.filter { photo ->
            photo.albumId == albumId
        }
    }
}