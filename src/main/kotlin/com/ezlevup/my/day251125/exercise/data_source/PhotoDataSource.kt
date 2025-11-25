package com.ezlevup.my.day251125.exercise.data_source

import com.ezlevup.my.core.Response
import com.ezlevup.my.day251125.exercise.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotos(): Response<List<PhotoDto>>
}
