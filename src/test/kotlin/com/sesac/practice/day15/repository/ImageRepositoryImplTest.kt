package com.sesac.practice.day15.repository

import com.sesac.practice.day15.datasource.ImageDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.io.File
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ImageRepositoryImplTest {

    private val repository = ImageRepositoryImpl(
        object : ImageDataSource {
            override suspend fun fetchImage(url: String): ByteArray {
                return FILE_BYTE_ARRAY
            }

            override suspend fun saveImage(bytes: ByteArray, path: String) {
                val file = File(FILE_NAME)

                file.writeBytes(FILE_BYTE_ARRAY)
            }
        },
    )

    @Test
    fun `URL 에서 이미지를 다운로드하여 지정된 경로에 저장한다`() = runTest {
        // given
        val url = "https://test.com/image.png"
        val path = "/images"

        // when
        repository.saveImage(url, path)

        // then
        val file = File(FILE_NAME)

        assertTrue(file.exists())

        file.delete()
    }

    @Test
    fun `여러 URL 의 이미지들을 지정된 디렉토리에 저장한다`() = runTest {
        // given
        val urls = listOf(
            "https://test.com/image.png",
            "https://test.com/image2.png",
        )
        val directory = "/images"

        // when
        repository.saveImages(urls, directory)

        // then
        val file = File(FILE_NAME)
        val file2 = File(FILE_NAME)

        assertTrue(file.exists())
        assertTrue(file2.exists())

        file.delete()
        file2.delete()
    }

    @Test
    fun `이미지가 존재하지 않는 경우 URL 에서 다운로드하여 저장하고 true 를 반환한다`() = runTest {
        // given
        val url = "https://test.com/image.png"
        val path = FILE_NAME

        // when
        val exist = repository.saveImageIfNotExist(url, path)

        // then
        assertTrue(exist)

        val file = File(FILE_NAME)

        assertTrue(file.exists())

        file.delete()
    }

    @Test
    fun `이미지가 존재하는 경우 다운로드 하지 않고 false 를 반환한다`() = runTest {
        // given
        val url = "https://test.com/image.png"
        val path = FILE_NAME

        val file = File(FILE_NAME)
        file.createNewFile()

        // when
        val exist = repository.saveImageIfNotExist(url, path)

        // then
        assertFalse(exist)

        file.delete()
    }

    companion object {
        const val FILE_NAME = "image.png"
        val FILE_BYTE_ARRAY = byteArrayOf(1, 2, 3)
    }
}
