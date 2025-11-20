package com.sesac.practice.day14.comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}
