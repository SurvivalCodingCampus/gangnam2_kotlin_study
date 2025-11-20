package com.neouul.sesac.`13-modelClass-repository`.comments

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.File

interface CommentDataSource {
    suspend fun loadComments(): List<Comment>
}

class CommentDataSourceImpl(
    private val path: String = "docs/data_source/comments.json",
) : CommentDataSource {
    // return을 쓰면 에러남
    // 람다의 마지막 줄이 반환값이므로 return를 삭제
    override suspend fun loadComments(): List<Comment> = withContext(Dispatchers.IO) {
        Json.decodeFromString(File(path).readText())
    }
}

class MockCommentDatasourceImpl(
    private val comments: List<Comment>,
) : CommentDataSource {
    override suspend fun loadComments(): List<Comment> {
        return comments
    }
}