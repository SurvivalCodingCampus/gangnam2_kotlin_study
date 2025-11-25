package com.hhp227.kotlinstudy.`16_dto`

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}