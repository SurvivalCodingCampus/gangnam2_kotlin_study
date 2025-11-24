package com.neouul.sesac.`14-network`.Exercise.repository

import com.neouul.sesac.`14-network`.Exercise.data_source.ImageDataSource
import com.neouul.sesac.`14-network`.Exercise.data_source.ImageDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.File

class ImageRepositoryImplTest {
    companion object {
        private const val URL1 = "https://cdn.pixabay.com/photo/2020/05/09/18/19/cat-5150858_1280.jpg"
        private const val URL2 = "https://cdn.pixabay.com/photo/2020/04/27/09/21/cat-5098930_1280.jpg"
        private const val URL3 = "https://cdn.pixabay.com/photo/2020/05/06/18/04/cat-5138554_1280.jpg"

        private const val PATH1 = "./test-image1.png"
        private const val PATH2 = "./test-image2.png"
        private const val DIRECTORY = "./test-directory/"
    }

    private val imageDataSource: ImageDataSource = ImageDataSourceImpl()
    private val imageRepository: ImageRepository = ImageRepositoryImpl(imageDataSource)
    private val urls = listOf(URL1, URL2, URL3)

    @Before
    fun setUp() = runBlocking {
        File(PATH1).delete()
        File(PATH2).delete()

        File(DIRECTORY).deleteRecursively()

        imageRepository.saveImage(URL2, PATH2)
    }

    @Test
    fun `saveImage 메서드 성공`() = runBlocking {
        imageRepository.saveImage(URL1, PATH1)

        val file = File(PATH1)
        assertTrue(file.readBytes().isNotEmpty())
    }

    @Test
    fun `saveImages 메서드 성공`() = runBlocking {
        imageRepository.saveImages(urls, DIRECTORY)

        val file = File(DIRECTORY)
        file.listFiles().forEach {
            assertTrue(it.readBytes().isNotEmpty())
        }
    }

    @Test
    fun `saveImageIfNotExists 메서드 성공`() = runBlocking {
        val result = imageRepository.saveImageIfNotExists(URL1, PATH1)

        assertEquals(true, result)
    }

    @Test
    fun `saveImageIfNotExists 메서드 실패`() = runBlocking {
        val result = imageRepository.saveImageIfNotExists(URL1, PATH2)

        assertEquals(false, result)
    }

    @After
    fun fileDelete() {
        File(PATH1).delete()
        File(PATH2).delete()

        File(DIRECTORY).deleteRecursively()
    }
}