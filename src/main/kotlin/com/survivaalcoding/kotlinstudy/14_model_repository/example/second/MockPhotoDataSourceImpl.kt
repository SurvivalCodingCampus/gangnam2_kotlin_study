package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

import kotlinx.serialization.json.Json
import java.io.File

class MockPhotoDataSourceImpl(val file: File) : PhotoDataSource {
    override suspend fun getPhoto(): List<Photo> {
        val readText = file.readText()

        return Json.decodeFromString(readText)
    }
}