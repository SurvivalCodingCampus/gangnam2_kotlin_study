package com.neouul.sesac.`14-network`.Exercise.data_source

import com.neouul.sesac.`14-network`.Exercise.core.Response
import com.neouul.sesac.`14-network`.Exercise.model.Post

interface RemoteDataSource {
    suspend fun getPosts(): Response<String>
    suspend fun getPost(id: Int): Response<String>
    suspend fun createPost(post: Post): Response<String>
    suspend fun updatePost(id: Int, post: Post): Response<String>
    suspend fun patchPost(id: Int, post: Post): Response<String>
    suspend fun deletePost(id: Int): Response<String>
}