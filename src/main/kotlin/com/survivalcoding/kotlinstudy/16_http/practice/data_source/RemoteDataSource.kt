package com.survivalcoding.kotlinstudy.`16_http`.practice.data_source

import com.survivalcoding.kotlinstudy.`16_http`.practice.model.Post
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Response

interface RemoteDataSource {
    suspend fun getPost(): Response<List<Post>>
    suspend fun getPost(id: Int): Response<Post>
    suspend fun createPost(post: Post): Response<Post>
    suspend fun updatePost(id: Int, post: Post): Response<Post>
    suspend fun patchPost(id: Int, post: Post): Response<Post>
    suspend fun deletePost(id: Int): Response<Unit>
}