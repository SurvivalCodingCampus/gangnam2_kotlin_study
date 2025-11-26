package com.ezlevup.my.day251125.exercise.repository

import com.ezlevup.my.day251125.exercise.data_source.PhotoDataSource
import com.ezlevup.my.day251125.exercise.mapper.toPhoto
import com.ezlevup.my.day251125.exercise.model.Photo

class PhotoRepositoryImpl(
    private val photoDataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        return photoDataSource.getPhotos().body.orEmpty().map { it ->
            it.toPhoto()
        }
    }
}
