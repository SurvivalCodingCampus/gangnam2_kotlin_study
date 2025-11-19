package _251119_datasource.exercise3

import kotlinx.serialization.json.Json
import java.io.File

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> {
        val file = File(FILE_PATH).readText()
        return Json.decodeFromString(file)
    }
}