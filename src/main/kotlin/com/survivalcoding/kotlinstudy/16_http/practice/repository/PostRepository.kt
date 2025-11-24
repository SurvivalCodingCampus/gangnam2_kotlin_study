package com.survivalcoding.kotlinstudy.`16_http`.practice.repository

import com.survivalcoding.kotlinstudy.`16_http`.practice.model.Post
import com.survivalcoding.kotlinstudy.repository.core.Response

interface PostRepository {
    suspend fun getPostByKeyword(keyword: String): Response<List<Post>>
}