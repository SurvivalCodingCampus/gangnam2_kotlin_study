package com.luca.kotlinstudy._16_http.repository

import com.luca.kotlinstudy._16_http.datasource.ImageDataSource
import java.io.File

class ImageRepositoryImpl(
    private val dataSource: ImageDataSource
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        val bytes = dataSource.fetchImage(url)
        dataSource.saveImage(bytes, path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        urls.forEachIndexed { index, url ->
            val filePath = "$directory/$index.jpg"
            saveImage(url, filePath)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        val file = File(path)
        if (file.exists() && file.isFile) {
            return false
        }
        val bytes = dataSource.fetchImage(url)
        dataSource.saveImage(bytes, path)
        return true
    }
}