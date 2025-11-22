package com.hhp227.kotlinstudy.`15_http`.image

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.io.IOException
import java.io.File
import java.io.FileOutputStream

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        val response = client.get(url)
        return if (response.status.isSuccess()) response.bodyAsBytes()
        else throw IOException("이미지 가져오기 실패: ${response.status}")
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val file = File(path)

        require(bytes.isNotEmpty()) { "이미지 데이터가 비어 있습니다" }
        if (!file.exists()) {
            file.createNewFile()
        }
        FileOutputStream(file).use { it.write(bytes) }
    }
}