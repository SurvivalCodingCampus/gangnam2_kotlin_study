package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Album
import kotlinx.serialization.json.Json
import java.io.File

class FileAlbumDataSourceImpl(
    private val fileName: String = "albums.json",
) : AlbumDataSource {
    override suspend fun getAllAlbums(): List<Album> {
        val file = File(fileName)
        val json = file.readText()
        return Json.decodeFromString<List<Album>>(json)
    }
}
