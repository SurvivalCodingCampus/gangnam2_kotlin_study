package com.luca.kotlinstudy._15_model_repository.dataSource.comment

import com.luca.kotlinstudy._15_model_repository.model.Comment
import kotlinx.serialization.json.Json
import java.io.File

// JSON 파일에서 댓글 데이터를 읽어오는 DataSource 구현체
class FileCommentDatasourceImpl(
    private val filePath: String
) : CommentDataSource {
    override suspend fun getComments(postId: Int): List<Comment> {
        val jsonText = File(filePath).readText()
        val all: List<Comment> = Json.decodeFromString(jsonText)
        val comments = all.filter { it.postId == postId }
        return comments
    }
}