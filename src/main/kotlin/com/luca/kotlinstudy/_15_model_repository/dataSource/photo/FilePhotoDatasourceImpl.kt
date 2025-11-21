package com.luca.kotlinstudy._15_model_repository.dataSource.photo

import com.luca.kotlinstudy._15_model_repository.model.Photo
import kotlinx.serialization.json.Json
import java.io.File

// JSON 파일에서 Photo 데이터를 읽어오는 DataSource 구현체
class FilePhotoDatasourceImpl(
    private val filePath: String
) : PhotoDatasource {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        val jsonText = File(filePath).readText()
        val all: List<Photo> = Json.decodeFromString(jsonText)
        val photos = all.filter { it.albumId == albumId }
        return photos
    }
}
