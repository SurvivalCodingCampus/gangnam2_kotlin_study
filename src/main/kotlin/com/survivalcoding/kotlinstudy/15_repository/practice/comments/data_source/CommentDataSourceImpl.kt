package com.survivalcoding.kotlinstudy.`15_repository`.practice.comments.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.comments.model.Comment
import kotlinx.serialization.json.Json
import java.io.File

class CommentDataSourceImpl(
    private val file: File
): CommentDataSource {
    override suspend fun getCommentsFileData(): List<Comment> {
        return Json.decodeFromString(file.readText())
    }
}