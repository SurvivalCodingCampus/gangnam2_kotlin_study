package com.survivalcoding.kotlinstudy.`16_network`.data_source

import com.survivalcoding.kotlinstudy.`16_network`.core.Response
import com.survivalcoding.kotlinstudy.`16_network`.model.Post

interface RemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Int): Response<Post>
    suspend fun createPost(post: Post): Response<Post>
    suspend fun updatePost(id: Int, post: Post): Response<Post>
    suspend fun patchPost(id: Int, post: Post): Response<Post>
    suspend fun deletePost(id: Int): Response<Unit>
}