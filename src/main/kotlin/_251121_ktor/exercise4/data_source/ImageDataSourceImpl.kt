package _251121_ktor.exercise4.data_source

import _251121_ktor.exercise4.core.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        val result = client.get(url)
        return result.bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        File(path).writeBytes(bytes)
    }
}

