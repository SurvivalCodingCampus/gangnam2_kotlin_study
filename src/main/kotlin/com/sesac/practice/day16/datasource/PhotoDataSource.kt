package com.sesac.practice.day16.datasource

import com.sesac.practice.day16.core.Response
import com.sesac.practice.day16.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotos(): Response<List<PhotoDto>>
}
