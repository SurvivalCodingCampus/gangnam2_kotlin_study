package com.survivalcoding.kotlinstudy.`16_network`.data_source

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.io.File
import kotlin.test.AfterTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ImageDataSourceImplTest {
    companion object {
        private const val IMAGE_URL =
            "https://i.namu.wiki/i/aTbi29NRCb4ztf4E-9Ckzf2In7xmzRy6kzLJX33Qq1ThS9mfER-LDdCx3WJy-f8pv3GOuhs3J4a7PXxCwG9awwtnaqFQsiGkzuleDi7G16Gt-g0Sru_tKJ7zoMaMMqKpIX2m80mfp9pnV4G7BosBSw.webp"

        private const val SAMPLE_PATH = "/16_network/sample.webp"
        private const val OUTPUT_DIR = "build/test-output"
        private const val CONTENT_TYPE = "image/webp"
    }

    private lateinit var tempFile: File

    private val realBytes = this::class.java.getResource(SAMPLE_PATH)!!.readBytes()

    @AfterTest
    fun tearDown() {
        if (::tempFile.isInitialized && tempFile.exists()) {
            tempFile.delete()
        }
    }

    @Test
    fun `fetchImage 성공 - 실제 ByteArray와 비교`() = runBlocking {
        // given
        val mockEngine = MockEngine { request ->
            assertEquals(IMAGE_URL, request.url.toString())

            respond(
                content = ByteReadChannel(realBytes),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, CONTENT_TYPE)
            )
        }

        val client = HttpClient(mockEngine)
        val dataSource = ImageDataSourceImpl(client)

        // when
        val result = dataSource.fetchImage(IMAGE_URL)

        // then
        assertTrue(result.contentEquals(realBytes))
    }

    @Test
    fun `saveImage 성공 - 파일 생성 및 내용 확인`() = runBlocking {
        // given
        val fileName = IMAGE_URL.substringAfterLast("/")
        tempFile = File("$OUTPUT_DIR/$fileName")

        val dataSource = ImageDataSourceImpl()

        // when
        dataSource.saveImage(realBytes, tempFile.path)

        // then
        assertTrue(tempFile.exists())
        assertTrue(realBytes.contentEquals(tempFile.readBytes()))
    }
}
