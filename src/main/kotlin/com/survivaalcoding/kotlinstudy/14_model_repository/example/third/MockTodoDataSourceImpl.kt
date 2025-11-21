package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.third

import java.io.File

class MockTodoDataSourceImpl(val file: File) : TodoDataSource {
    override suspend fun getTodo() = listOf(
        Todo(1L, 1L, "title1", true),
        Todo(2L, 2L, "title2", true),
        Todo(3L, 1L, "title3", false)
    )
}