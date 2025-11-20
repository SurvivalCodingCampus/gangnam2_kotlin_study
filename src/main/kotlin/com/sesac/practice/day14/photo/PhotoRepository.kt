package com.sesac.practice.day14.photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}
