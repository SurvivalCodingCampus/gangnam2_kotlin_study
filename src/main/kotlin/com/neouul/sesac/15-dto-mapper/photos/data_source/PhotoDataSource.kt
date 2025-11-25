package com.neouul.sesac.`15-dto-mapper`.photos.data_source

interface PhotoDataSource {
    suspend fun loadPhotos(): List
}