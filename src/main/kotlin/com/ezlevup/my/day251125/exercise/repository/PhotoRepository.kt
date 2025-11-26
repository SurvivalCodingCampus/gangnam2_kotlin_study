package com.ezlevup.my.day251125.exercise.repository

import com.ezlevup.my.day251125.exercise.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}