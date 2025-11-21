package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Photo
import kotlinx.serialization.json.Json
import java.io.File

class FilePhotoDataSourceImpl(
    val fileName: String = "photos.json",
) : PhotoDataSource {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        val file = File(fileName)
        val json = file.readText()
        return Json.decodeFromString<List<Photo>>(json).filter { it.albumId == albumId }
    }
}