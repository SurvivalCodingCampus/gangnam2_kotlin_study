package com.survivalcoding.kotlinstudy.`16_network`.repository

import com.survivalcoding.kotlinstudy.`16_network`.MockImageDataSource
import com.survivalcoding.kotlinstudy.`16_network`.mock.ImageDataSourceMockEngine
import io.ktor.client.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ImageRepositoryImplTest {

    companion object {
        // URL
        private const val IMAGE_URL =
            "https://i.namu.wiki/i/aTbi29NRCb4ztf4E-9Ckzf2In7xmzRy6kzLJX33Qq1ThS9mfER-LDdCx3WJy-f8pv3GOuhs3J4a7PXxCwG9awwtnaqFQsiGkzuleDi7G16Gt-g0Sru_tKJ7zoMaMMqKpIX2m80mfp9pnV4G7BosBSw.webp"

        // Directory & Path
        private const val DIRECTORY = "test-output"
        private const val IMAGE_NAME = "image.webp"
        private const val SAVE_PATH = "$DIRECTORY/$IMAGE_NAME"

        // Sample image bytes
        private val SAMPLE_BYTES = byteArrayOf(1, 2, 3, 4)
    }

    @Test
    fun `saveImage 성공`() = runBlocking {
        // given
        val engine = ImageDataSourceMockEngine.fetchSuccess(SAMPLE_BYTES)
        val client = HttpClient(engine)
        val mockDataSource = MockImageDataSource(client)
        val repository = ImageRepositoryImpl(mockDataSource)

        // when
        repository.saveImage(IMAGE_URL, SAVE_PATH)

        // then
        assertEquals(SAVE_PATH, mockDataSource.savedPath)
        assertTrue(mockDataSource.savedBytes!!.contentEquals(SAMPLE_BYTES))
    }

    @Test
    fun `saveImages 여러개 저장`() = runBlocking {
        // given
        val engine = ImageDataSourceMockEngine.fetchSuccess(SAMPLE_BYTES)
        val client = HttpClient(engine)
        val mockDataSource = MockImageDataSource(client)
        val repository = ImageRepositoryImpl(mockDataSource)

        val urls = listOf(IMAGE_URL, IMAGE_URL)

        // when
        repository.saveImages(urls, DIRECTORY)

        // then
        assertTrue(mockDataSource.savedBytes!!.contentEquals(SAMPLE_BYTES))
    }

    @Test
    fun `saveImagesIfNotExists - 파일이 없으면 저장`() = runBlocking {
        // given
        val engine = ImageDataSourceMockEngine.fetchSuccess(SAMPLE_BYTES)
        val client = HttpClient(engine)
        val mockDataSource = MockImageDataSource(client)
        val repository = ImageRepositoryImpl(mockDataSource)

        // when
        val result = repository.saveImageIfNotExists(IMAGE_URL, SAVE_PATH)

        // then
        assertTrue(result)
        assertEquals(SAVE_PATH, mockDataSource.savedPath)
    }
}
