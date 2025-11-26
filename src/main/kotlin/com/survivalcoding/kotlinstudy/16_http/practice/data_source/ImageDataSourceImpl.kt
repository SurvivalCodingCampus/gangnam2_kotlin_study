package com.survivalcoding.kotlinstudy.`16_http`.practice.data_source

import com.survivalcoding.kotlinstudy.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import java.io.File

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        return client.get(url).body()
    }

    override suspend fun saveImage(byte: ByteArray, path: String) {
        val file = File(path)
        file.writeBytes(byte)
    }
}