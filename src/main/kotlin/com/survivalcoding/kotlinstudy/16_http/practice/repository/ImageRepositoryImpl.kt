package com.survivalcoding.kotlinstudy.`16_http`.practice.repository

import com.survivalcoding.kotlinstudy.`16_http`.practice.data_source.ImageDataSource
import java.io.File

class ImageRepositoryImpl(
    private val dataSource: ImageDataSource
) : ImageRepository {

    private fun ensureDir(path: String): File {
        val dir = File(path)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        return dir
    }

    private suspend fun downloadAndSaveImage(url: String, dir: File) {
        val imageByte: ByteArray = dataSource.fetchImage(url)

        val rawName: String = url.substringAfterLast('/')
        if (rawName.isBlank()) {
        throw IllegalArgumentException("유효한 파일명을 추출할 수 없습니다: $url")
        }
        val fileName: String = rawName.replace(Regex("[^A-Za-z0-9._-]"), "_")

        val filePath: String = File(dir, fileName).toString()
        dataSource.saveImage(imageByte, filePath)
    }

    override suspend fun saveImage(url: String, path: String) {
        val dir = ensureDir(path)
        downloadAndSaveImage(url, dir)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        val dir = ensureDir(directory)

        urls.forEach { url ->
            downloadAndSaveImage(url, dir)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        val dir = ensureDir(path)

        val hasImageFile: Boolean = dir
            .listFiles { _, name ->
                val lower = name.lowercase()
                lower.endsWith(".jpg") ||
                        lower.endsWith(".jpeg") ||
                        lower.endsWith(".png") ||
                        lower.endsWith(".webp")
            }?.isNotEmpty() == true

        if (hasImageFile) {
            return false
        }

        downloadAndSaveImage(url, dir)

        return true
    }
}
