package com.survival.kotlinstudy.day16.datasource

import com.survival.kotlinstudy.day16.model.Post
import com.survival.kotlinstudy.day16.model.Response

interface RemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Int): Response<Post>
    suspend fun createPost(post: Post): Response<Post>
    suspend fun updatePost(id: Int, post: Post): Response<Post>
    suspend fun patchPost(id: Int, post: Post): Response<Post>
    suspend fun deletePost(id: Int): Response<Post>
}