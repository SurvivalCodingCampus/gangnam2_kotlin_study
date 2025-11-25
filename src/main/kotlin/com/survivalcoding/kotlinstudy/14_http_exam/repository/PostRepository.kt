package com.survivalcoding.kotlinstudy.`14_http_exam`.repository

import Post

interface PostRepository {
    suspend fun getPostsByKeyword(keyword: String): List<Post>
}