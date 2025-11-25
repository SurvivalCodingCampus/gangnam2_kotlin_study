package com.neouul.sesac.`14-network`.Exercise.repository

import com.neouul.sesac.`14-network`.Exercise.model.Post

interface PostRepository {
    suspend fun getPostsByKeyword(keyword: String): List<Post>
}