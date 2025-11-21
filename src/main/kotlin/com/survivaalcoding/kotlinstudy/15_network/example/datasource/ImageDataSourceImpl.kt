package com.survivaalcoding.kotlinstudy.`15_network`.example.datasource

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File

class ImageDataSourceImpl(val httpClient: HttpClient = HttpClient(CIO)) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        val response = httpClient.get(url)

        return response.bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val file = File(path)
        file.writeBytes(bytes)
    }
}