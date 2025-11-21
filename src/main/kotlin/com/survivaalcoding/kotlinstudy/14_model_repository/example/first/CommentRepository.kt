package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first

interface CommentRepository {
    suspend fun getComments(postId: Long): List<Comment>
}