package _251119_datasource.exercise2

import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        val file = File(FILE_PATH).readText()
        return Json.decodeFromString(file)
    }
}