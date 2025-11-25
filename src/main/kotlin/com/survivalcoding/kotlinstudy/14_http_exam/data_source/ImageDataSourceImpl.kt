package com.survivalcoding.kotlinstudy.`14_http_exam`.data_source

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File

class ImageDataSourceImpl(
    private val httpClient: HttpClient = HttpClient(),
) : ImageDataSource {

    override suspend fun fetchImage(url: String): ByteArray = withContext(Dispatchers.IO) {
        val response = httpClient.get(url)
        response.bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) = withContext(Dispatchers.IO) {
        val file = File(path)
        file.writeBytes(bytes)
    }
}

fun main(): Unit = runBlocking {
    val dataSource = ImageDataSourceImpl()
    val bytes = dataSource.fetchImage("https://cdn.spotvnews.co.kr/news/photo/202409/704412_1101896_1119.jpg")

    dataSource.saveImage(bytes, "아이유.jpg")
}