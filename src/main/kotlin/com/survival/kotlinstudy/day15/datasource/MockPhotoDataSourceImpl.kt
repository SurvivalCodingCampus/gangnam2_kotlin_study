package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Photo
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl(
    private val text: String
) : PhotoDataSource {

    override suspend fun getPhotos(): List<Photo> {
        return Json.decodeFromString(text)
    }
}