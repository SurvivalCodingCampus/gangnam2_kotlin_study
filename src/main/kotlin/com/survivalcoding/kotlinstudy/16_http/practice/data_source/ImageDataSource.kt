package com.survivalcoding.kotlinstudy.`16_http`.practice.data_source

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(byte: ByteArray, path: String)
}