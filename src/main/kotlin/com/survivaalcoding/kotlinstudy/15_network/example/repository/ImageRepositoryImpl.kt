package com.survivaalcoding.kotlinstudy.`15_network`.example.repository

import com.survivaalcoding.kotlinstudy.`15_network`.example.datasource.ImageDataSource
import java.io.File

class ImageRepositoryImpl(val dataSource: ImageDataSource) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        savedImage(url, path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        if (!File(directory).isDirectory) {
            throw IllegalStateException("디렉토리가 존재하지 않습니다.")
        }

        urls.forEach { url ->
            val path = "$directory/${System.currentTimeMillis()}.png"
            savedImage(url, path)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        if (File(path).exists()) {
            return false
        }

        savedImage(url, path)
        return true
    }

    private suspend fun savedImage(url: String, path: String) {
        dataSource.saveImage(dataSource.fetchImage(url), path)
    }
}