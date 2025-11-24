package com.survivalcoding.kotlinstudy.`16_http`.practice.image.data_source

import com.survivalcoding.kotlinstudy.`16_http`.practice.data_source.ImageDataSource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.*
import java.io.File

object MockImageDataSourceImpl : ImageDataSource {

    private const val MOCK_IMAGE_PATH =
        "src/test/kotlin/com/survivalcoding/kotlinstudy/16_http/practice/image/data_source"

    val mockEngine: MockEngine = MockEngine { request ->
        val url: String = request.url.toString()

        val fileName: String = when {
            url.contains("1") -> "MockImage1.jpg"
            url.contains("2") -> "MockImage2.png"
            else -> error("Error")
        }

        val file = File(MOCK_IMAGE_PATH, fileName)

        val contentType: String =
            if (fileName.endsWith(".png")) "image/png" else "image/jpg"

        respond(
            content = ByteReadChannel(file.readBytes()),
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, contentType)
        )
    }

    private val client: HttpClient = HttpClient(mockEngine)

    override suspend fun fetchImage(url: String): ByteArray {
        return client.get(url).body()
    }

    override suspend fun saveImage(byte: ByteArray, path: String) {
        val file = File(path)
        file.writeBytes(byte)
    }
}