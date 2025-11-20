package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Comment
import kotlinx.serialization.json.Json
import java.io.File

class MockCommentDataSourceImpl() : CommentDataSource {
    override suspend fun getComments(): List<Comment> {
        val json = File("src/main/resources/15_model_class_repository/comments.json").readText()

        return Json.decodeFromString(json)
    }
}