package com.survivalcoding.kotlinstudy.`14_http_exam`.data_source

import Post

interface RemoteDataSource {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Long): Post?
    suspend fun createPost(post: Post): Post?
    suspend fun updatePost(id: Long, post: Post): Post?
    suspend fun patchPost(id: Long, post: Post): Post?
    suspend fun deletePost(id: Long)
}