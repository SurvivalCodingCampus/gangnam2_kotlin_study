package com.luca.kotlinstudy._15_model_repository.dataSource.photo

import com.luca.kotlinstudy._15_model_repository.model.Photo
import kotlinx.serialization.json.Json
import java.io.File

class MockPhotoDatasourceImpl(
    private val filePath: String,
) : PhotoDataSource {
    override suspend fun getComments(albumId: Int): List<Photo> {
        val jsonText = File(filePath).readText()
        val decodeComments: List<Photo> = Json.decodeFromString(jsonText)
        val allPhotos = decodeComments.filter { it.albumId == albumId }
        return allPhotos
    }
}