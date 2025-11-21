package com.luca.kotlinstudy._15_model_repository.dataSource.album

import com.luca.kotlinstudy._15_model_repository.model.Album
import kotlinx.serialization.json.Json
import java.io.File

// JSON 파일에서 Album 리스트를 읽어오는 구현체
class FileAlbumDatasourceImpl(
    private val filePath: String
) : AlbumDatasource {

    override suspend fun getAlbums(): List<Album> {
        val jsonText = File(filePath).readText()
        return Json.decodeFromString(jsonText)
    }
}
