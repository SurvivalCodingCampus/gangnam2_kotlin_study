package com.survivalcoding.kotlinstudy.`16_http`.practice.repository

import com.survivalcoding.kotlinstudy.`16_http`.practice.model.Post
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Response

interface PostRepository {
    suspend fun getPostByKeyword(keyword: String): Response<List<Post>>
}