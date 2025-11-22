package com.sesac.practice.day15.datasource

import com.sesac.practice.day15.core.ApiException
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ImageDataSourceImplTest {

    private val baseUrl = "https://test.com"
    private val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            "$baseUrl/image.png" -> {
                respond(
                    byteArrayOf(1, 2, 3),
                    HttpStatusCode.OK,
                )
            }

            "$baseUrl/error.png" -> {
                respond(
                    "error",
                    HttpStatusCode.BadRequest,
                )
            }

            else -> {
                throw IllegalArgumentException("잘못된 요청입니다.")
            }
        }
    }
    private val httpClient = HttpClient(mockEngine)
    private val dataSource = ImageDataSourceImpl(httpClient)

    @Test
    fun `URL 에서 사진을 받아 바이트 배열을 반환한다`() = runTest {
        // given
        val url = "$baseUrl/image.png"

        // when
        val bytes = dataSource.fetchImage(url)

        // then
        assertEquals(3, bytes.size)
    }

    @Test
    fun `사진을 저장한다`() = runTest {
        // given
        val bytes = byteArrayOf()
        val path = "tmp.png"

        // when
        dataSource.saveImage(bytes, path)

        // then
        val file = File(path)

        assertTrue(file.exists())
        assertTrue(file.isFile())
        assertEquals(path, file.name)
        assertEquals("png", file.extension)

        file.delete()
    }

    @Test(expected = ApiException::class)
    fun `URL 에서 사진을 받지 못할 경우 에러가 발생한다`() = runTest {
        // given
        val url = "$baseUrl/error.png"

        // when // then
        val bytes = dataSource.fetchImage(url)
    }
}
