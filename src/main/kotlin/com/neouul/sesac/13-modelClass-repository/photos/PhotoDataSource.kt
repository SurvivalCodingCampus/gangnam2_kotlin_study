package com.neouul.sesac.`13-modelClass-repository`.photos

import kotlinx.serialization.json.Json
import java.io.File

interface PhotoDataSource {
    suspend fun jsonToPhotos(): List<Photo>
}

class PhotoDataSourceImpl(
    private val path: String = "docs/data_source/photos.json",
) : PhotoDataSource {
    override suspend fun jsonToPhotos(): List<Photo> {
        val json = File(path).readText()
        return Json.decodeFromString(json)
    }
}