package _251120_test_double_model_class_repository.exercise2

import _251120_test_double_model_class_repository.common_config.FILEPATH2
import kotlinx.serialization.json.Json
import java.io.File

class PhotoDataSourceImpl : PhotoDataSource {
    override suspend fun getAllPhotos(): List<Photo> {
        val file = File(FILEPATH2).readText()
        return Json.decodeFromString(file)
    }
}