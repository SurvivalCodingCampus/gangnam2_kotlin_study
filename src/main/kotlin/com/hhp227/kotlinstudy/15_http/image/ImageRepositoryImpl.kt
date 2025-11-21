package com.hhp227.kotlinstudy.`15_http`.image

import java.io.File
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ImageRepositoryImpl(
    private val imageDataSource: ImageDataSource
) : ImageRepository {
    private val cache = LruCache<String, String>(10)

    override suspend fun saveImage(url: String, path: String) {
        val byteArray = imageDataSource.fetchImage(url)
        imageDataSource.saveImage(byteArray, path)
        cache[url] = path
    }

    @OptIn(ExperimentalUuidApi::class)
    override suspend fun saveImages(urls: List<String>, directory: String) {
        val file = File(directory)

        if (!file.exists()) file.mkdirs()
        if (file.isDirectory) urls.forEachIndexed { i, url ->
            val path = File(directory, "image${i}_${Uuid.random().toHexString()}.jpg").path

            saveImage(url, path)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        if (cache[url] != null) return false
        else saveImage(url, path)
        return true
    }

    fun clearCache() {
        cache.clear()
    }
}