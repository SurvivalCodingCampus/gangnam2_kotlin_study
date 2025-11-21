package com.survivaalcoding.kotlinstudy.`15_network`.example.datasource

import com.survivaalcoding.kotlinstudy.`15_network`.example.core.Response
import com.survivaalcoding.kotlinstudy.`15_network`.example.model.Post

interface RemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Long): Response<Post?>
    suspend fun createPost(post: Post): Response<Post>
    suspend fun updatePost(id: Long, post: Post): Response<Post>
    suspend fun patchPost(id: Long, post: Post): Response<Post>
    suspend fun deletePost(id: Long): Response<Unit>
}