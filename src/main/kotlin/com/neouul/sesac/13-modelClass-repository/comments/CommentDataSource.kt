package com.neouul.sesac.`13-modelClass-repository`.comments

import kotlinx.serialization.json.Json
import java.io.File

interface CommentDataSource {
    suspend fun loadComments(): List<Comment>
}

class CommentDataSourceImpl(
    private val path: String = "docs/data_source/comments.json",
) : CommentDataSource {
    override suspend fun loadComments(): List<Comment> {
        val json = File(path).readText()
        return Json.decodeFromString(json)
    }
}

class MockCommentDatasourceImpl(
    private val comments: List<Comment>,
): CommentDataSource {
    override suspend fun loadComments(): List<Comment> {
        return comments
    }
}