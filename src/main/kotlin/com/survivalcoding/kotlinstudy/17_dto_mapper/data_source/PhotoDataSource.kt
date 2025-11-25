package com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotos(): List<PhotoDto>
}