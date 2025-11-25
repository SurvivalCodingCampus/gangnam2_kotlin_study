package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.datasource

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.core.Response
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotos(): Response<List<PhotoDto>>
}