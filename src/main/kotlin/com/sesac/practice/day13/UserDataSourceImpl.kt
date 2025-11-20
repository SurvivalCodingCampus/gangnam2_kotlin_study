package com.sesac.practice.day13

import java.io.File

class UserDataSourceImpl(
    val filename: String,
) : UserDataSource {
    override suspend fun getUsers(): List<User> {
        val file = File(filename)

        return file.decodeFromFile()
    }
}
