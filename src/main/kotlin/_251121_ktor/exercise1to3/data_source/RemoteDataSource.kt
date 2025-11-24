package _251121_ktor.exercise1to3.data_source

import _251121_ktor.exercise1to3.model.Post
import _251121_ktor.exercise1to3.model.Response
import io.ktor.http.*

interface RemoteDataSource {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun getPost(id: Int): Response<Post>
    suspend fun createPost(newPost: Post): Response<Post>
    suspend fun updatePost(id: Int, updatePost: Post): Response<Post>
    suspend fun patchPost(id: Int, updatePost: Post): Response<Post>
    suspend fun deletePost(id: Int): HttpStatusCode
}