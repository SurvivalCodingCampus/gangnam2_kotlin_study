package com.hhp227.kotlinstudy.`15_http`.post

import com.hhp227.kotlinstudy.`15_http`.Response

interface PostRemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Int): Response<Post?>
    suspend fun createPost(post: Post): Response<Post>
    suspend fun updatePost(id: Int, post: Post): Response<Post?>
    suspend fun patchPost(id: Int, post: Post): Response<Post>
    suspend fun deletePost(id: Int): Response<Boolean>
}