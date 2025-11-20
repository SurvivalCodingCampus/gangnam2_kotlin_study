package com.sesac.practice.day14.photo

interface PhotoDataSource {
    suspend fun getPhotos(): List<Photo>
}
