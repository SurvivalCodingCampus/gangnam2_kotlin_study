package com.sesac.practice.day16.repository

import com.sesac.practice.day16.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}
