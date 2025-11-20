package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Comment
import kotlinx.serialization.json.Json
import java.io.File

class FileCommentDataSourceImpl(
    private val filePath: String
) : CommentDataSource {

    override suspend fun getComments(): List<Comment> {
        val file = File(filePath)
        return Json.decodeFromString(file.readText())
    }

}