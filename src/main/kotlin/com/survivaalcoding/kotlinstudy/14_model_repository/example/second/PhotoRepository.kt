package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

interface PhotoRepository {
    suspend fun getPhotos(albumId: Long): List<Photo>
}