package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Album
import kotlinx.serialization.json.Json
import java.io.File

class MockAlbumDataSourceImpl(
    private val filePath: String
) : AlbumDataSource {

    override suspend fun getAlbums(): List<Album> {
        val file = File(filePath)
        return Json.decodeFromString(file.readText())
    }
}