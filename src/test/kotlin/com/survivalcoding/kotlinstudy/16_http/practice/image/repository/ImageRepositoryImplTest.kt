package com.survivalcoding.kotlinstudy.`16_http`.practice.image.repository

import com.survivalcoding.kotlinstudy.`16_http`.practice.data_source.ImageDataSource
import com.survivalcoding.kotlinstudy.`16_http`.practice.image.data_source.MockImageDataSourceImpl
import com.survivalcoding.kotlinstudy.`16_http`.practice.repository.ImageRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import java.io.File
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ImageRepositoryImplTest {

    private val dataSource: ImageDataSource = MockImageDataSourceImpl
    private val repository = ImageRepositoryImpl(dataSource)

    @Test
    fun `saveImage()가 잘 작동하는지 확인`() = runBlocking {
        val testUrl1 = "http://test/MockImage1.jpg"
        val testUrl2 = "http://test/MockImage2.jpg"

        val testDir = "01_imageSet"

        val file1 = File(testDir, "MockImage1.jpg")
        val file2 = File(testDir, "MockImage2.jpg")

        repository.saveImage(testUrl1, testDir)
        repository.saveImage(testUrl2, testDir)

        assertTrue(file1.exists())
        assertTrue(file2.exists())
    }

    @Test
    fun `saveImages()가 잘 작동하는지 확인`() = runBlocking {
        val testUrls: List<String> = listOf("http://test/MockImage1.jpg", "http://test/MockImage2.jpg")

        val testDir = "02_imageSet"

        val file1 = File(testDir, "MockImage1.jpg")
        val file2 = File(testDir, "MockImage2.jpg")

        repository.saveImages(testUrls, testDir)

        assertTrue(file1.exists())
        assertTrue(file2.exists())
    }

    @Test
    fun `saveImageIfNotExists()가 잘 작동하는지 확인`() = runBlocking {
        val testUrl1 = "http://test/MockImage1.jpg"
        val testUrl2 = "http://test/MockImage2.jpg"

        val testDir = "03_imageSet"

        val file1 = File(testDir, "MockImage1.jpg")
        val file2 = File(testDir, "MockImage2.jpg")

        repository.saveImage(testUrl1, testDir)
        repository.saveImageIfNotExists(testUrl2, testDir)

        assertTrue(file1.exists())
        assertFalse(file2.exists())
    }

    @AfterEach
    fun cleanupDir() {
        val dirs = listOf(
            "01_imageSet",
            "02_imageSet",
            "03_imageSet"
        )

        dirs.forEach { dir ->
            val file = File(dir)
            if (file.exists()) {
                file.deleteRecursively()
            }
        }
    }
}