package com.survivalcoding.kotlinstudy.`16_network`.repository

import com.survivalcoding.kotlinstudy.`16_network`.model.Post

interface PostRepository {
    suspend fun getPostByKeyword(keyword: String): List<Post>?
}