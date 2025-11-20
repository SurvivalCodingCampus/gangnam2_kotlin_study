package _251120_test_double_model_class_repository.exercise2

import kotlinx.serialization.json.Json
import java.io.File

class PhotoDataSourceImpl(val filePath: String) : PhotoDataSource {
    override suspend fun getAllPhotos(): List<Photo> {
        val file = File(filePath).readText()
        return Json.decodeFromString(file)
    }
}