package com.survival.kotlinstudy.day16.datasource

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals


class ImageDataSourceImplTest {
    private val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            "https://test.com/image1.png" -> {
                respond(
                    content = ByteReadChannel(byteArrayOf(1, 2, 3)),
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type", "image/png")
                )
            }

            else -> {
                respondError(HttpStatusCode.NotFound)
            }
        }
    }

    private val client = HttpClient(mockEngine)
    private val dataSource = ImageDataSourceImpl(client)

    @Test
    fun `fetchImage 테스트`() = runBlocking {
        val url = "https://test.com/image1.png"

        val bytes = dataSource.fetchImage(url)

        assertEquals(3, bytes.size)
        assertEquals(1, bytes[0])
        assertEquals(2, bytes[1])
        assertEquals(3, bytes[2])
    }

    @Test
    fun `saveImage 테스트`(): Unit = runBlocking {
        val bytes = byteArrayOf(9, 8, 7)
        val path = "savetest.png"
        val file = File(path)

        dataSource.saveImage(bytes, path)


        assertTrue(file.exists())
        assertTrue(file.isFile)
        assertEquals(3, file.readBytes().size)
        assertEquals(9, file.readBytes()[0])

        file.delete()

    }

}