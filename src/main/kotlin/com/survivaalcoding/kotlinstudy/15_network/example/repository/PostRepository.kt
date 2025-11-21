package com.survivaalcoding.kotlinstudy.`15_network`.example.repository

import com.survivaalcoding.kotlinstudy.`15_network`.example.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Long): Post?
    suspend fun createPost(post: Post): Post
    suspend fun updatePost(id: Long, post: Post): Post
    suspend fun patchPost(id: Long, post: Post): Post
    suspend fun deletePost(id: Long)
    suspend fun getPostsByKeyword(keyword: String): List<Post>
}