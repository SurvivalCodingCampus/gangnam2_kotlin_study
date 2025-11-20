package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Album
import com.survivalcoding.kotlinstudy.common.readJsonFile

class MockAlbumDataSourceImpl : AlbumDataSource {
    override suspend fun getAlbums(): List<Album> {
        return readJsonFile("src/main/resources/15_model_class_repository/albums.json")
    }
}