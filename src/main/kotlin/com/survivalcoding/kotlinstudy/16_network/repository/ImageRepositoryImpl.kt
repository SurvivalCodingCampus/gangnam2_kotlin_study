package com.survivalcoding.kotlinstudy.`16_network`.repository

import com.survivalcoding.kotlinstudy.`16_network`.data_source.ImageDataSource
import java.io.File

class ImageRepositoryImpl(
    private val dataSource: ImageDataSource
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        val bytes = dataSource.fetchImage(url)
        dataSource.saveImage(bytes, path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {

    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        val file = File(path)

        // 파일이 존재하면 False
        if (file.exists()) {
            return false
        }

        // 파일이 없으면 저장하고 True
        val bytes = dataSource.fetchImage(url)
        dataSource.saveImage(bytes, path)
        return true
    }
}