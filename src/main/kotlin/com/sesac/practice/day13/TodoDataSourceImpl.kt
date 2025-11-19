package com.sesac.practice.day13

import java.io.File

class TodoDataSourceImpl(
    val filename: String,
) : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val file = File(filename)

        return file.decodeFromFile()
    }

    override suspend fun getTodos(): List<Todo> {
        val file = File(filename)

        return file.decodeFromFile()
    }
}
