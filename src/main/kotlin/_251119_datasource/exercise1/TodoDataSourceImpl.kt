package _251119_datasource.exercise1

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.File

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val file = File(FILE_PATH).readText()
        return Json.decodeFromString(file)
    }
}

fun main(): Unit = runBlocking {
    val todoDataSourceImpl = TodoDataSourceImpl()
    println(todoDataSourceImpl.getTodo())
}