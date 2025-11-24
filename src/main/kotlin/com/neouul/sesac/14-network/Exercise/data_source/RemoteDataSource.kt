package com.neouul.sesac.`14-network`.Exercise.data_source

import com.neouul.sesac.`14-network`.Exercise.core.Response
import com.neouul.sesac.`14-network`.Exercise.model.Post

interface RemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Int): Response<Post?>
    suspend fun createPost(post: Post): Response<Post>
    suspend fun updatePost(id: Int, post: Post): Response<Post?>
    suspend fun patchPost(id: Int, post: Post): Response<Post?>
    suspend fun deletePost(id: Int): Response<Unit>
}