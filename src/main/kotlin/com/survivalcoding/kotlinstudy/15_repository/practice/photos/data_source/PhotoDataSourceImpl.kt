package com.survivalcoding.kotlinstudy.`15_repository`.practice.photos.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.photos.model.Photo
import kotlinx.serialization.json.Json
import java.io.File

class PhotoDataSourceImpl(
    private val file: File
): PhotoDataSource {
    override suspend fun getPhotosFileData(): List<Photo> {
        return Json.decodeFromString(file.readText())
    }
}