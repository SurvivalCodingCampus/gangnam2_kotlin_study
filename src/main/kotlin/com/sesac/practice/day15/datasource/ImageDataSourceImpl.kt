package com.sesac.practice.day15.datasource

import com.sesac.practice.day15.core.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create(),
) : ImageDataSource {

    override suspend fun fetchImage(url: String): ByteArray {
        val response = client.get(url)

        return response.bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val file = File(path)

        file.writeBytes(bytes)
    }
}
