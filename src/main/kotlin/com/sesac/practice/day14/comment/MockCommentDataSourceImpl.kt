package com.sesac.practice.day14.comment

import kotlinx.serialization.json.Json
import java.io.File

class MockCommentDataSourceImpl(
    private val pathname: String,
) : CommentDataSource {

    override suspend fun getComments(): List<Comment> {
        val file = File(pathname)
        val json = file.readText()

        return Json.decodeFromString(json)
    }
}
