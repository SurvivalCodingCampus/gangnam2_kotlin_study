package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Album
import kotlinx.serialization.json.Json
import java.io.File

class MockAlbumDataSourceImpl : AlbumDataSource {
    override suspend fun getAlbums(): List<Album> {
        val json = File("src/main/resources/15_model_class_repository/albums.json").readText()

        return Json.decodeFromString(json)
    }
}