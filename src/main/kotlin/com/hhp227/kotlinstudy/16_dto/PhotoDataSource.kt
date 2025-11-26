package com.hhp227.kotlinstudy.`16_dto`

interface PhotoDataSource {
    suspend fun fetchPhotos(): List<PhotoDto>
}