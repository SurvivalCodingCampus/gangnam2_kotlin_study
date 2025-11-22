package com.hhp227.kotlinstudy.`15_http`.image

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}