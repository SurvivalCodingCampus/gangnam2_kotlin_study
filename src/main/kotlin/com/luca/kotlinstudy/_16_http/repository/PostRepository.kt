package com.luca.kotlinstudy._16_http.repository

import com.luca.kotlinstudy._16_http.model.Post

interface PostRepository {
    suspend fun getPostsByKeyword(keyword: String): List<Post>
}
