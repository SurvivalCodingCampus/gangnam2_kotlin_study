package com.ezlevup.my.day251121.exercise.data_source

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
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