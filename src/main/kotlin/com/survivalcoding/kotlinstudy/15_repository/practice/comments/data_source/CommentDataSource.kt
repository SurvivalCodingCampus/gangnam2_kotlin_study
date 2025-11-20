package com.survivalcoding.kotlinstudy.`15_repository`.practice.comments.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.comments.model.Comment

interface CommentDataSource {
    suspend fun getCommentsFileData(): List<Comment>
}