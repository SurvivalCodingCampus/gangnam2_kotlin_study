package com.survival.kotlinstudy.day16.datasource

import com.survival.kotlinstudy.day16.model.Post
import com.survival.kotlinstudy.day16.model.Response

class MockDataSourceImpl: RemoteDataSource {
    val post1 = Post(id = 1, userId = 1, title = "Test Title", body = "Test Body")
    val post2 = Post(id = 2, userId = 2, title = "Test Title", body = "Test Body")
    val post3 = Post(id = 3, userId = 3, title = "Title", body = "Test Body")
    val post4 = Post(id = 4, userId = 4, title = "Title", body = "Test Body")
    val list = listOf(post1,post2,post3,post4)
    override suspend fun getPosts(): Response<List<Post>> {
        return Response(codeStatus = 200, header = mapOf(), body = list)
    }

    override suspend fun getPost(id: Int): Response<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun createPost(post: Post): Response<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun updatePost(id: Int, post: Post): Response<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun patchPost(id: Int, post: Post): Response<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun deletePost(id: Int): Response<Post> {
        TODO("Not yet implemented")
    }
}