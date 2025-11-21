package com.survivaalcoding.kotlinstudy.`15_network`.example.repository

import com.survivaalcoding.kotlinstudy.`15_network`.example.datasource.ImageDataSource
import com.survivaalcoding.kotlinstudy.`15_network`.example.datasource.ImageDataSourceImpl
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import java.io.File
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ImageRepositoryImplTest {
    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `url에서 이미지를 다운로드하여 지정된 경로에 저장한다`() = runTest {
        // given
        val fileName = "${DIR_PATH}/${Uuid.random()}.png"
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
        val repository: ImageRepository = ImageRepositoryImpl(dataSource)

        // when
        repository.saveImage(IMAGE_URL1, fileName)

        // then
        val file = File(fileName)
        val readBytes = file.readBytes()

        assertTrue(file.exists())
        assertContentEquals(tinyPng, readBytes)
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `여러 url의 이미지들을 지정된 디렉토리에 저장할 수 있다`() = runTest {
        // given
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
        val repository: ImageRepository = ImageRepositoryImpl(dataSource)

        // when
        repository.saveImages(listOf(IMAGE_URL1, IMAGE_URL2), DIR_PATH)

        // then
        val file = File(DIR_PATH)
        assertTrue(file.isDirectory())
    }

    @Test
    fun `여러 url의 이미지들을 저장할 때 디렉토리가 아니면 예외가 발생한다`() = runTest {
        // given
        val nonExistsDir = "$DIR_PATH/dir/"
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
        val repository: ImageRepository = ImageRepositoryImpl(dataSource)

        // when
        // then
        assertThrows<IllegalStateException> {
            repository.saveImages(listOf(IMAGE_URL1, IMAGE_URL2), nonExistsDir)
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `파일이 없으면 이미지를 다운로드하여 저장하고 true를 반환한다`() = runTest {
        // given
        val fileName = "${DIR_PATH}/${Uuid.random()}.png"
        val tinyPng: ByteArray = byteArrayOf(1, 2, 3)

        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(tinyPng),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, ContentType.Image.PNG.toString())
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource: ImageDataSource = ImageDataSourceImpl(apiClient)
        val repository: ImageRepository = ImageRepositoryImpl(dataSource)

        // when
        val result = repository.saveImageIfNotExists(IMAGE_URL1, fileName)

        // then
        val file = File(fileName)

        assertTrue(result)
        assertTrue(file.exists())
        assertContentEquals(tinyPng, file.readBytes())
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `파일이 이미 있으면 저장하지 않고 false를 반환한다`() = runTest {
        // given
        val fileName = "${DIR_PATH}/${Uuid.random()}.png"
        val tinyPng: ByteArray = byteArrayOf(1, 2, 3)

        File(fileName).writeBytes(byteArrayOf(1, 2, 3))

        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(tinyPng),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, ContentType.Image.PNG.toString())
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource: ImageDataSource = ImageDataSourceImpl(apiClient)
        val repository: ImageRepository = ImageRepositoryImpl(dataSource)

        // when
        val result = repository.saveImageIfNotExists(IMAGE_URL1, fileName)

        // then
        val savedBytes = File(fileName).readBytes()

        assertFalse(result)
        assertContentEquals(byteArrayOf(1, 2, 3), savedBytes)
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/15_network/example/file/"
        private const val IMAGE_URL1 =
            "https://i.namu.wiki/i/0R1ca91o_jqqSx1InXeUg7VTe8Nilwc34GdIGKxujsusmU2lv77VQg5NnAL-tgGl5RvTgW3HyJ2zLRbHQCZdYzoc8_odJKldFtjyZBFZLLSPbKDbkGSxx8H6VEV05WV-kixMHsTjvTUG1bHZ-_hu_w.webp"
        private const val IMAGE_URL2 =
            "https://upload.wikimedia.org/wikipedia/commons/2/24/Go_Youn-jung_on_January_26%2C_2025.png"
    }
}