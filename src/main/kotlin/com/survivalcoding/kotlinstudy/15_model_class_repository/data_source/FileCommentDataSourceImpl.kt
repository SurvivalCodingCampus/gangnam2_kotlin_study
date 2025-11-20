package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Comment
import com.survivalcoding.kotlinstudy.common.readJsonFile

class FileCommentDataSourceImpl : CommentDataSource {
    override suspend fun getComments(): List<Comment> {
        return readJsonFile("src/main/resources/15_model_class_repository/comments.json")
    }
}