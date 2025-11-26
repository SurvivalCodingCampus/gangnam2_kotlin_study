package com.neouul.sesac.`15-dto-mapper`.photos.repository

import com.neouul.sesac.`15-dto-mapper`.photos.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}