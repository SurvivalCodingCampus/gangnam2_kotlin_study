package _251121_ktor.data_source

import _251121_ktor.model.Post
import _251121_ktor.model.Response

interface RemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Int): Response<Post>
    suspend fun createPost(newPost: Post): Post
    suspend fun updatePost(id: Int, updatePost: Post): Post
    suspend fun patchPost(id: Int, updatePost: Post): Post
    suspend fun deletePost(id: Int)
}