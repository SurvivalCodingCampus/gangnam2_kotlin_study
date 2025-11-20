package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}
