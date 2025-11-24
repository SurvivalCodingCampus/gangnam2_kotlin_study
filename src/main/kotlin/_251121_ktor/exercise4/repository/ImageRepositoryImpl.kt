package _251121_ktor.exercise4.repository

import _251121_ktor.exercise4.data_source.ImageDataSource
import kotlinx.io.files.FileNotFoundException
import java.io.File

class ImageRepositoryImpl(
    private val imageDataSource: ImageDataSource
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        imageDataSource.saveImage(imageDataSource.fetchImage(url), path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        urls.forEachIndexed { index, url ->
            imageDataSource.saveImage(imageDataSource.fetchImage(url), directory + "${index + 1}")
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        val file = File(path)
        try {
            file.readText()
            return true
        } catch (e: FileNotFoundException) {
            imageDataSource.saveImage(imageDataSource.fetchImage(url), path)
            return false
        }
    }
}

