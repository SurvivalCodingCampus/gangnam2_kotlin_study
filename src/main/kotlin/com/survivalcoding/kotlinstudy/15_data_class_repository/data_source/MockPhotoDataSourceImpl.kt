package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Photo
import kotlinx.serialization.json.Json
import java.io.File

class MockPhotoDataSourceImpl : PhotoDataSource {
    override suspend fun getPhotos(): List<Photo> {
        val json = File("src/main/resources/15_model_class_repository/photos.json").readText()

        return Json.decodeFromString(json)
    }
}