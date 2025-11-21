package com.survivaalcoding.kotlinstudy.`15_network`.example.datasource

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}