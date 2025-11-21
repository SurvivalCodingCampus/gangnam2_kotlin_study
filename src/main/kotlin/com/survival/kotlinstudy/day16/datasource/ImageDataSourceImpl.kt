package com.survival.kotlinstudy.day16.datasource

import com.survival.kotlinstudy.day16.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        val response = client.get(url)

        return response.body()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        withContext(Dispatchers.IO) {
            val file = File(path)
            file.parentFile?.mkdirs()
            file.writeBytes(bytes)
        }
    }
}