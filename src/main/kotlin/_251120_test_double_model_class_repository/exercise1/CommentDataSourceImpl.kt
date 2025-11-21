package _251120_test_double_model_class_repository.exercise1

import kotlinx.serialization.json.Json
import java.io.File

class CommentDataSourceImpl(val filePath: String) : CommentDataSource {
    override suspend fun getComments(): List<Comment> {
        val file = File(filePath).readText()
        return Json.decodeFromString(file)
    }
}