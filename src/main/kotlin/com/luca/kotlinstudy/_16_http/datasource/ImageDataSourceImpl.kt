package com.luca.kotlinstudy._16_http.datasource

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsBytes
import io.ktor.http.isSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : ImageDataSource {

    override suspend fun fetchImage(url: String): ByteArray {
        val response = client.get(url)
        if (!response.status.isSuccess()) {
            throw IllegalStateException("이미지 다운로드 실패")
        }
        return response.bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        withContext(Dispatchers.IO) {
            val file = File(path)
            file.parentFile?.mkdirs()
            file.writeBytes(bytes)
        }
    }
}