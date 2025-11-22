package com.ezlevup.my.day251121.exercise.repository

import com.ezlevup.my.day251121.exercise.core.FileUtils
import com.ezlevup.my.day251121.exercise.data_source.ImageDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class ImageRepositoryImplTest {
    @Before
    fun setUp() {

    }

    @Test
    fun saveImage(): Unit = runBlocking {
        // given
        val imageRepository = ImageRepositoryImpl(ImageDataSourceImpl())

        // when
        val directory: String = "images"
        val url = "https://shopping-phinf.pstatic.net/main_5621418/56214188047.20250812122730.jpg?type=w300"
        val fileName = FileUtils.extractFileName(url)
        val savePath = "$directory/$fileName"

        FileUtils.deleteFile(savePath)
        imageRepository.saveImage(url, savePath)

        // then
        val fileExists = FileUtils.isFileExists(savePath)
        assertTrue(fileExists)
    }

    @Test
    fun saveImages(): Unit = runBlocking {
        // given
        val imageRepository = ImageRepositoryImpl(ImageDataSourceImpl())

        // when
        val directory: String = "images"

        val urls = listOf<String>(
            "https://imgnews.pstatic.net/image/015/2010/09/18/2010091899467_2010091851891.jpg?type=w647",
            "https://imgnews.pstatic.net/image/origin/112/2025/11/21/3781904.jpg?type=m1024_768",
            "https://imgnews.pstatic.net/image/109/2025/11/18/0005432729_001_20251118081817183.jpg?type=m1024_768",
            "https://imgnews.pstatic.net/image/609/2025/11/12/202511120725592410_1_20251112072712257.jpg?type=m1024_768",
        )

        // 기존 파일 삭제
        urls.forEach { url ->
            val fileName = FileUtils.extractFileName(url)
            val savePath = "$directory/$fileName"
            FileUtils.deleteFile(savePath)
        }

        imageRepository.saveImages(urls, directory)

        // then
        urls.forEach { url ->
            val fileName = FileUtils.extractFileName(url)
            val savePath = "$directory/$fileName"
            val fileExists = FileUtils.isFileExists(savePath)
            assertTrue(fileExists)
        }

    }

    @Test
    fun saveImageIfNotExists(): Unit = runBlocking {
        // given
        val imageRepository = ImageRepositoryImpl(ImageDataSourceImpl())

        // when
        val directory: String = "images"
        val url = "https://shopping-phinf.pstatic.net/main_5621418/56214188047.20250812122730.jpg?type=w300"
        val fileName = FileUtils.extractFileName(url)
        val savePath = "$directory/$fileName"

        FileUtils.deleteFile(savePath)
        val result: Boolean = imageRepository.saveImageIfNotExists(url, savePath)

        // then
        val fileExists = FileUtils.isFileExists(savePath)
        assertTrue(fileExists)
        assertTrue(result)
    }

}