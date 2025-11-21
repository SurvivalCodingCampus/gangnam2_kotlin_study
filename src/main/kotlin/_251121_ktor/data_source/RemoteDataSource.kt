package _251121_ktor.data_source

import _251121_ktor.model.Post

interface RemoteDataSource {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Int): Post
    suspend fun createPost(newPost: Post): Post
    suspend fun updatePost(id: Int, updatePost: Post): Post
    suspend fun patchPost(id: Int, updatePost: Post): Post
    suspend fun deletePost(id: Int)
}