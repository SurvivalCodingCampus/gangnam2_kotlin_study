package com.neouul.sesac.`14-network`.Exercise.data_source

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}