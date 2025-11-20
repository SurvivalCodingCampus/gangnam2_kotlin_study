package _251120_test_double_model_class_repository.exercise3

import _251120_test_double_model_class_repository.common_config.FILEPATH3
import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl : TodoDataSource {

    override suspend fun getAllMemo(): List<Todo> {
        val file = File(FILEPATH3).readText()
        return Json.decodeFromString(file)
    }
}