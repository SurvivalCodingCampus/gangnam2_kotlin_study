package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}
