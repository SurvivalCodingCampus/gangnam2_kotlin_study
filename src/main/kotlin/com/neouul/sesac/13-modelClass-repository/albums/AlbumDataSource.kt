package com.neouul.sesac.`13-modelClass-repository`.albums

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.File

interface AlbumDataSource {
    suspend fun loadAlbums(): List<Album>
}

class AlbumDataSourceImpl(
    private val path: String = "docs/data_source/albums.json",
) : AlbumDataSource {
    override suspend fun loadAlbums(): List<Album> = withContext(Dispatchers.IO) {
        Json.decodeFromString(File(path).readText())
    }
}