package com.survivalcoding.kotlinstudy.`16_network`.data_source

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}
