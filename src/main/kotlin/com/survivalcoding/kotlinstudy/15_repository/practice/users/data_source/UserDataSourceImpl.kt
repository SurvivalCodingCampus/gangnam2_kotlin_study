package com.survivalcoding.kotlinstudy.`15_repository`.practice.users.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.model.User
import kotlinx.serialization.json.Json
import java.io.File

class UserDataSourceImpl(
    private val file: File
) : UserDataSource {
    override suspend fun getUsersFileData(): List<User> {
        return Json.decodeFromString(file.readText())
    }
}