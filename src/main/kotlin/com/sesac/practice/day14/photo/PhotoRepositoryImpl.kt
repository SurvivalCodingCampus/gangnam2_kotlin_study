package com.sesac.practice.day14.photo

class PhotoRepositoryImpl(
    private val photoDataSource: PhotoDataSource,
) : PhotoRepository {

    override suspend fun getPhotos(albumId: Int): List<Photo> {
        val photos = photoDataSource.getPhotos()

        return photos.filter { it.albumId == albumId }
    }
}
