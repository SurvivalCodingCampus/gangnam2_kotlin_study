package com.hhp227.kotlinstudy.`15_http`.post

interface PostRepository {
    suspend fun getPostsByKeyword(keyword: String): List<Post>
}