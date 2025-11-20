package com.sesac.practice.day14.todo

import com.sesac.practice.day14.decodeFromFile
import java.io.File

class MockTodoDataSourceImpl(
    private val pathname: String,
) : TodoDataSource {

    override suspend fun getTodos(): List<Todo> {
        val file = File(pathname)

        return file.decodeFromFile()
    }
}
