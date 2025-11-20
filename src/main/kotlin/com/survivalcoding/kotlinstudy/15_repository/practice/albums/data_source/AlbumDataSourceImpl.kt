package com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.model.Album
import kotlinx.serialization.json.Json
import java.io.File

class AlbumDataSourceImpl(
    private val file: File
): AlbumDataSource {
    override suspend fun getAlbumFileData(): List<Album> {
        return Json.decodeFromString(file.readText())
    }
}