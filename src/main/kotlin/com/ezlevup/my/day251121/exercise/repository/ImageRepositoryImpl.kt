package com.ezlevup.my.day251121.exercise.repository

import com.ezlevup.my.core.FileUtils
import com.ezlevup.my.day251121.exercise.data_source.ImageDataSource

class ImageRepositoryImpl(
    val imageDataSource: ImageDataSource
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        val image = imageDataSource.fetchImage(url)
        imageDataSource.saveImage(image, path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        urls.forEach { url ->
            val fileName = FileUtils.extractFileName(url)
            val savePath = "$directory/$fileName"
            saveImage(url, savePath)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        if (FileUtils.isFileExists(path)) {
            return false // 파일 있어요.
        }

        return try {
            val image = imageDataSource.fetchImage(url)
            imageDataSource.saveImage(image, path)
            true // 성공
        } catch (e: Exception) {
            false // 실패
        }
    }
}
