package com.sesac.practice.day15.repository

import com.sesac.practice.day15.model.Post

interface PostRepository {
    suspend fun getPostsByKeyword(keyword: String): List<Post>
}
