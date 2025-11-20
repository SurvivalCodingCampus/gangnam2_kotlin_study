package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Photo
import kotlinx.serialization.json.Json
import java.io.File

class FilePhotoDataSourceImpl(
    private val filePath: String
) : PhotoDataSource {

    override suspend fun getPhotos(): List<Photo> {
        val file = File(filePath)
        return Json.decodeFromString(file.readText())
    }
}