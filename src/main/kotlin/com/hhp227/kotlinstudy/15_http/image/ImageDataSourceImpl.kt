package com.hhp227.kotlinstudy.`15_http`.image

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import java.io.File
import java.io.FileOutputStream

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        val response = client.get(url)
        return if (response.status.isSuccess()) response.bodyAsBytes() else ByteArray(0)
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val file = File(path)

        if (bytes.isEmpty()) throw Exception("올바른 파일이 아닙니다")
        if (!file.exists()) {
            file.createNewFile()
        }
        FileOutputStream(file).use { it.write(bytes) }
    }
}