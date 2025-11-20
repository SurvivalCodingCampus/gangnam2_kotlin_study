package _251120_test_double_model_class_repository.exercise4

import _251120_test_double_model_class_repository.common_config.FILEPATH4
import kotlinx.serialization.json.Json
import java.io.File

class UserDataSourceImpl : UserDataSource {
    override suspend fun getAllUser(): List<User> {
        val file = File(FILEPATH4).readText()
        return Json.decodeFromString(file)
    }
}