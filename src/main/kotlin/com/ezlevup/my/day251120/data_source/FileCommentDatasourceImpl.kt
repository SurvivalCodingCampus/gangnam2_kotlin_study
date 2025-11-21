package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Comment
import kotlinx.serialization.json.Json
import java.io.File

class FileCommentDatasourceImpl(
    val fileName: String = "comments.json",
) : CommentDataSource {
    override suspend fun getComments(postId: Int): List<Comment> {
        val file = File(fileName)
        val json = file.readText()
        return Json.decodeFromString<List<Comment>>(json).filter { it.postId == postId }
    }
}
