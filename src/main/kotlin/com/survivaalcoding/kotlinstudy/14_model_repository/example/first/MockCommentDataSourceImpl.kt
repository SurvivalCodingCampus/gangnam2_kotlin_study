package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first

import kotlinx.serialization.json.Json
import java.io.File

class MockCommentDataSourceImpl(val file: File) : CommentDataSource {
    override suspend fun getComments(): List<Comment> {
        val readText = file.readText()

        return Json.decodeFromString(readText)
    }
}