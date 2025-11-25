package com.survivaalcoding.kotlinstudy.`15_network`.example.datasource

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.isSuccess
import java.io.File

class ImageDataSourceImpl(val httpClient: HttpClient = HttpClient(CIO)) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        val response = httpClient.get(url)

        if (!response.status.isSuccess()) {
            throw IllegalStateException("이미지 다운로드 실패: ${response.status}")
        }

        return response.bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val file = File(path)
        file.writeBytes(bytes)
    }
}