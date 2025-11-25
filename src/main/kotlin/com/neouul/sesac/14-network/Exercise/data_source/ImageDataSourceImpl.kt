package com.neouul.sesac.`14-network`.Exercise.data_source

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsBytes
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