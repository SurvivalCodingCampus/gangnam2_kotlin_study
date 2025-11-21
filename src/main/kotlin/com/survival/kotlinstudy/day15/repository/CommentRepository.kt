package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}