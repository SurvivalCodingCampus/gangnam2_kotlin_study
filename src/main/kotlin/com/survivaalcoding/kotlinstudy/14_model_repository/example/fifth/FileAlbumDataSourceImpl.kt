package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fifth

import kotlinx.serialization.json.Json
import java.io.File

class FileAlbumDataSourceImpl(val file: File) : AlbumDataSource {
    override suspend fun getAlbum(): List<Album> {
        val readText = file.readText()

        return Json.decodeFromString(readText)
    }
}