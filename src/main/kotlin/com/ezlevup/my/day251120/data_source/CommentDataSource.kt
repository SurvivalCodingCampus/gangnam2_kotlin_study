package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Comment

interface CommentDataSource {
    suspend fun getComments(postId: Int): List<Comment>
}