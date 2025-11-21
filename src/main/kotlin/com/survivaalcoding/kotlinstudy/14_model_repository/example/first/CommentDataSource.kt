package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first

interface CommentDataSource {
    suspend fun getComments(): List<Comment>
}