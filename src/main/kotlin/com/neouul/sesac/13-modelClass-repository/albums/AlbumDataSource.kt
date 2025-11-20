package com.neouul.sesac.`13-modelClass-repository`.albums

import kotlinx.serialization.json.Json
import java.io.File

interface AlbumDataSource {
    suspend fun jsonToAlbums(): List<Album>
}

class AlbumDataSourceImpl(
    private val path: String = "docs/data_source/albums.json",
) : AlbumDataSource {
    override suspend fun jsonToAlbums(): List<Album> {
        val json = File(path).readText()
        return Json.decodeFromString(json)
    }
}