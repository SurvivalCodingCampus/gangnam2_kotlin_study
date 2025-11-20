package com.neouul.sesac.`13-modelClass-repository`.comments

import kotlinx.serialization.json.Json
import java.io.File

interface CommentDataSource {
    suspend fun jsonToComments(): List<Comment>
}

class MockCommentDataSourceImpl(
    private val path: String = "docs/data_source/comments.json"
) : CommentDataSource {

    override suspend fun jsonToComments(): List<Comment> {
        val json = File(path).readText()
        return Json.decodeFromString(json)
    }
}