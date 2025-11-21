package com.survival.kotlinstudy.day16.repository

import com.survival.kotlinstudy.day16.datasource.ImageDataSource
import java.io.File

class ImageRepositoryImpl(
    private val dataSource: ImageDataSource
) : ImageRepository {

    override suspend fun saveImage(url: String, path: String) {
        val byte = dataSource.fetchImage(url)
        dataSource.saveImage(byte, path)

    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        urls.forEach { url ->
            val filename = url.substringAfterLast("/")
            val path = "$directory/$filename"
            saveImage(url,path)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        val file = File(path)
        if (file.exists()) return false

        saveImage(url, path)
        return true
    }
}