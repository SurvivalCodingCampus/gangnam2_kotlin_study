package com.survival.kotlinstudy.day17.datasource

import com.survival.kotlinstudy.day17.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotos(): List<PhotoDto>
}