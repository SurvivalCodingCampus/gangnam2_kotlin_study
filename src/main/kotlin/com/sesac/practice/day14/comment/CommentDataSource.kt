package com.sesac.practice.day14.comment

interface CommentDataSource {
    suspend fun getComments(): List<Comment>
}
