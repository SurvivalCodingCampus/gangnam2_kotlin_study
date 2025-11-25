package com.survivalcoding.kotlinstudy.`16_network`

import com.survivalcoding.kotlinstudy.`16_network`.data_source.ImageDataSource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class MockImageDataSource(
    private val client: HttpClient,
) : ImageDataSource {

    var savedPath: String? = null
    var savedBytes: ByteArray? = null

    override suspend fun fetchImage(url: String): ByteArray {
        return client.get(url).body()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        savedPath = path
        savedBytes = bytes
    }
}
