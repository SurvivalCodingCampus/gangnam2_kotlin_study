package com.survivalcoding.kotlinstudy.`15_repository`.practice.comments.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.comments.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}