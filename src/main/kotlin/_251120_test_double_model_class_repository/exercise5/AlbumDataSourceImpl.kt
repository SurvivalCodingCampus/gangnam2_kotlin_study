package _251120_test_double_model_class_repository.exercise5

import _251120_test_double_model_class_repository.common_config.FILEPATH5
import kotlinx.serialization.json.Json
import java.io.File

class AlbumDataSourceImpl(val filePath: String) : AlbumDataSource {
    override suspend fun getAllAlbum(): List<Album> {
        val file = File(filePath).readText()
        return Json.decodeFromString(file)
    }
}