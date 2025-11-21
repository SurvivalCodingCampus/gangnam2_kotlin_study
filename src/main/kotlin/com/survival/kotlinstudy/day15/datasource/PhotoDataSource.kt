package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Photo

interface PhotoDataSource {
    suspend fun getPhotos(): List<Photo>
}