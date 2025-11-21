package com.sesac.practice.day15.repository

import com.sesac.practice.day15.datasource.ImageDataSource
import java.io.File

class ImageRepositoryImpl(
    private val imageDataSource: ImageDataSource,
    private val defaultImageName: String = DEFAULT_IMAGE_NAME,
    private val defaultImageExtension: String = DEFAULT_IMAGE_EXTENSION,
) : ImageRepository {

    override suspend fun saveImage(url: String, path: String) {
        val bytes = imageDataSource.fetchImage(url)

        imageDataSource.saveImage(bytes, path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        urls.forEachIndexed { index, url ->
            saveImage(url, "$directory/$defaultImageName(${index + 1})$defaultImageExtension")
        }
    }

    override suspend fun saveImageIfNotExist(url: String, path: String): Boolean {
        val file = File(path)

        if (file.exists()) {
            return false
        }

        saveImage(url, path)

        return true
    }

    companion object {
        const val DEFAULT_IMAGE_NAME = "image"
        const val DEFAULT_IMAGE_EXTENSION = ".png"
    }
}
