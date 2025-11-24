package com.neouul.sesac.`14-network`.Exercise.data_source

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class ImageDataSourceImplTest {
    private val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            "https://test.com/image1.png" -> {
                respond(
                    content = ByteReadChannel(byteArrayOf(1, 2, 3)),
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type", "image/png"),
                )
            }

            "https://test.com/error.png" -> {
                respond(
                    content = ByteReadChannel("Error"),
                    status = HttpStatusCode.NotFound,
                )
            }

            else -> {
                respond(
                    content = ByteReadChannel(byteArrayOf()),
                    status = HttpStatusCode.NotFound,
                )
            }
        }
    }
    private val client: HttpClient = HttpClient(mockEngine)
    private val ImageDataSource: ImageDataSource = ImageDataSourceImpl(client)

    @Test
    fun `fetchImage 메서드 성공 - image1`() = runBlocking {
        val bytes = ImageDataSource.fetchImage("https://test.com/image1.png")

        println(bytes.joinToString(", "))
        println(bytes == byteArrayOf(1, 2, 3))  // false
        println(bytes.contentEquals(byteArrayOf(1, 2, 3)))  // true

        // 배열 비교를 위한 assert문
        assertArrayEquals(byteArrayOf(1, 2, 3), bytes)
    }

    @Test
    fun `fetchImage 메서드 실패 - error`() = runBlocking {
        val bytes = ImageDataSource.fetchImage("https://test.com/error.png")

        // 배열 비교를 위한 assert문
        assertArrayEquals("Error".encodeToByteArray(), bytes)
    }

    @Test
    fun `fetchImage 메서드 실패 - etc`() = runBlocking {
        val bytes = ImageDataSource.fetchImage("https://test.com/etc.png")

        // 배열 비교를 위한 assert문
        assertArrayEquals(byteArrayOf(), bytes)
    }
}