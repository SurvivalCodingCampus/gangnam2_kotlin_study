package com.survivalcoding.kotlinstudy.`16_network`.data_source

import com.survivalcoding.kotlinstudy.`16_network`.core.HttpClientFactory
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

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val file = File(path)

        file.parentFile?.mkdirs()

        file.writeBytes(bytes)
    }
}