package com.survivaalcoding.kotlinstudy.`15_network`.example.datasource

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.io.File
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

private const val IMAGE_URL =
    "https://i.namu.wiki/i/0R1ca91o_jqqSx1InXeUg7VTe8Nilwc34GdIGKxujsusmU2lv77VQg5NnAL-tgGl5RvTgW3HyJ2zLRbHQCZdYzoc8_odJKldFtjyZBFZLLSPbKDbkGSxx8H6VEV05WV-kixMHsTjvTUG1bHZ-_hu_w.webp"

class ImageDataSourceImplTest {
    @Test
    fun `url 이미지의 byte를 가져올 수 있다`() = runTest {
        // given
        val expected = byteArrayOf(1, 2, 3)

        val mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel(expected),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, ContentType.Image.PNG.toString())
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource: ImageDataSource = ImageDataSourceImpl(apiClient)

        // when
        val response = dataSource.fetchImage(IMAGE_URL)

        // then
        assertContentEquals(expected, response)
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `이미지 byte를 path에 저장한다`() = runTest {
        // given
        val fileName = "$DIR_PATH/${Uuid.random()}.png"
        val tinyPng: ByteArray = byteArrayOf(
            0x89.toByte(), 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A,
            0x00, 0x00, 0x00, 0x0D, 0x49, 0x48, 0x44, 0x52,
            0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x01,
            0x08, 0x06, 0x00, 0x00, 0x00, 0x1F, 0x15, 0xC4.toByte(), 0x89.toByte(),
            0x00, 0x00, 0x00, 0x0A, 0x49, 0x44, 0x41, 0x54,
            0x78, 0x9C.toByte(), 0x63, 0x60, 0x00, 0x00, 0x00, 0x02, 0x00, 0x01,
            0xE5.toByte(), 0x27, 0xD4.toByte(), 0xA2.toByte(),
            0x00, 0x00, 0x00, 0x00, 0x49, 0x45, 0x4E, 0x44, 0xAE.toByte(), 0x42, 0x60, 0x82.toByte()
        )

        val mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel(tinyPng),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, ContentType.Image.PNG.toString())
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource: ImageDataSource = ImageDataSourceImpl(apiClient)

        // when
        dataSource.saveImage(tinyPng, fileName)

        // then
        val file = File(fileName)
        val readBytes = file.readBytes()

        assertTrue(file.exists())
        assertContentEquals(tinyPng, readBytes)
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/15_network/example/file/"
        private const val IMAGE_URL =
            "https://i.namu.wiki/i/0R1ca91o_jqqSx1InXeUg7VTe8Nilwc34GdIGKxujsusmU2lv77VQg5NnAL-tgGl5RvTgW3HyJ2zLRbHQCZdYzoc8_odJKldFtjyZBFZLLSPbKDbkGSxx8H6VEV05WV-kixMHsTjvTUG1bHZ-_hu_w.webp"
    }
}