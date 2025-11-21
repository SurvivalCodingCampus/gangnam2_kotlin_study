package com.survival.kotlinstudy.day16.repository

import com.survival.kotlinstudy.day16.model.Post

interface PostRepository {
    suspend fun getPostsByKeyword(keyword: String): List<Post>?
}