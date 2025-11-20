package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockPhotoDataSourceImpl
import com.survival.kotlinstudy.day15.datasource.PhotoDataSource
import com.survival.kotlinstudy.day15.model.Photo
import kotlinx.coroutines.runBlocking

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return dataSource.getPhotos().filter { it.albumId == albumId }
    }

}

fun main() = runBlocking {
    val filePath = "data/photos.json"
    val repository = PhotoRepositoryImpl(MockPhotoDataSourceImpl(filePath))

    println(repository.getPhotos(1).joinToString("\n"))
}