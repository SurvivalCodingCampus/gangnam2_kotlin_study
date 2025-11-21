package com.sesac.practice.day15.datasource

import com.sesac.practice.day15.core.Response
import com.sesac.practice.day15.model.Post

interface RemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Long): Response<Post>
    suspend fun createPost(post: Post): Response<Post>
    suspend fun updatePost(id: Long, post: Post): Response<Post>
    suspend fun patchPost(id: Long, post: Post): Response<Post>
    suspend fun deletePost(id: Long): Response<Void>
}
