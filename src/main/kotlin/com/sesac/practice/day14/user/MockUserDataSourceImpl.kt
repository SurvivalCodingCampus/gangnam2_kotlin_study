package com.sesac.practice.day14.user

import com.sesac.practice.day14.decodeFromFile
import java.io.File

class MockUserDataSourceImpl(
    private val pathname: String,
) : UserDataSource {

    override suspend fun getUsers(): List<User> {
        val file = File(pathname)

        return file.decodeFromFile()
    }
}
