package com.survival.kotlinstudy.day16.repository

import com.survival.kotlinstudy.day16.datasource.MockImageDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.io.File
import kotlin.test.assertContentEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class ImageRepositoryImplTest {

    private val repository = ImageRepositoryImpl(MockImageDataSourceImpl())

    @Test
    fun `saveImage() 테스트`(): Unit = runBlocking {
        val url = "https://test/saveImage/image.png"
        val path = "image.png"
        val bytes = byteArrayOf(1, 2, 3)


        repository.saveImage(url, path)

        val file = File(path)

        assertTrue(file.exists())
        assertContentEquals(bytes, file.readBytes())

        file.delete()
    }

    @Test
    fun `saveImages() 테스트!`(): Unit = runBlocking {
        val url1 = "https://test/saveImages/image1.png"
        val url2 = "https://test/saveImages/image2.png"
        val urls = listOf(url1, url2)

        val dir = "data"

        repository.saveImages(urls, dir)

        urls.forEach { url ->
            val filename = url.substringAfterLast("/")
            val path = "$dir/$filename"
            val file = File(path)
            assertTrue(file.exists())
            file.delete()
        }
    }

    @Test
    fun `이미지가 없다면 다운로드 후 true 반환 테스트!`(): Unit = runBlocking {
        val url = "https://test/saveImages/image.png"
        val path = "image.png"

        val isExist = repository.saveImageIfNotExists(url, path)

        assertTrue(isExist)

        val file = File(path)

        assertTrue(file.exists())

        file.delete()
    }

    @Test
    fun `이미지가 있다면 false 반환 테스트`(): Unit = runBlocking {
        val url = "https://test/saveImages/image.png"
        val path = "image.png"


        val file = File(path)
        file.writeBytes(byteArrayOf(1))
        val result = repository.saveImageIfNotExists(url, path)


        assertFalse(!result)
        assertTrue(file.exists())

        file.delete()
    }
}