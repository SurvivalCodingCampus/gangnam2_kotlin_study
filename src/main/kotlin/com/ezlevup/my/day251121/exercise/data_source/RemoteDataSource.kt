package com.ezlevup.my.day251121.exercise.data_source

import com.ezlevup.my.day251121.exercise.model.Post


interface RemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Int): Response<Post>
    suspend fun createPost(post: Post): Response<Post>
    suspend fun updatePost(id: Int, post: Post): Response<Post>
    suspend fun patchPost(id: Int, post: Post): Response<Post>
    suspend fun deletePost(id: Int): Boolean
}
