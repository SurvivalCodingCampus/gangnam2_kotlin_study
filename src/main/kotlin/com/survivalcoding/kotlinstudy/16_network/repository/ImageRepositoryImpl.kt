package com.survivalcoding.kotlinstudy.`16_network`.repository

import com.survivalcoding.kotlinstudy.`16_network`.data_source.ImageDataSource
import java.io.File
import java.util.*

class ImageRepositoryImpl(
    private val dataSource: ImageDataSource
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        val bytes = dataSource.fetchImage(url)
        dataSource.saveImage(bytes, path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        File(directory).mkdirs()

        urls.forEachIndexed { index, url ->
            val extension = url.substringAfterLast(".", "jpg")  // 확장자 추출
            val fileName = "${UUID.randomUUID()}.$extension"
            val filePath = "$directory/$fileName"

            saveImage(url, filePath)
        }
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