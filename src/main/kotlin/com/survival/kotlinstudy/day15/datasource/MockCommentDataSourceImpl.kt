package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Comment
import kotlinx.serialization.json.Json

class MockCommentDataSourceImpl(
    private val text: String
) : CommentDataSource {

    override suspend fun getComments(): List<Comment> {
        return Json.decodeFromString(text)
    }

}