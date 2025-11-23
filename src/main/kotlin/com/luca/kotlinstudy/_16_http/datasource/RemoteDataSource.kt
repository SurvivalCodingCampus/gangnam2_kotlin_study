package com.luca.kotlinstudy._16_http.datasource

import com.luca.kotlinstudy._16_http.core.Response
import com.luca.kotlinstudy._16_http.model.Post

interface RemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Int): Response<Post?>
    suspend fun createPost(post: String): Response<Post?>
    suspend fun updatePost(id: Int, post: Post): Response<Post?>
    suspend fun patchPost(id: Int, post: Post): Response<Post?>
    suspend fun deletePost(id: Int): Response<Unit?>
}