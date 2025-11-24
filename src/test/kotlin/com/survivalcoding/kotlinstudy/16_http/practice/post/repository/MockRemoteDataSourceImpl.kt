package com.survivalcoding.kotlinstudy.`16_http`.practice.post.repository

import com.survivalcoding.kotlinstudy.`16_http`.practice.post.data_source.PostMockEngine
import com.survivalcoding.kotlinstudy.`16_http`.practice.data_source.RemoteDataSource
import com.survivalcoding.kotlinstudy.`16_http`.practice.data_source.RemoteDataSourceImpl
import com.survivalcoding.kotlinstudy.`16_http`.practice.model.Post
import com.survivalcoding.kotlinstudy.repository.core.Response
import io.ktor.client.HttpClient

class MockRemoteDataSourceImpl: RemoteDataSource {

    private val client = HttpClient(PostMockEngine.mockEngine)
    private val api = RemoteDataSourceImpl(client)

    override suspend fun getPost(): Response<List<Post>> {
        return Response(
            statusCode = api.getPost().statusCode,
            header = api.getPost().header,
            body = api.getPost().body
        )
    }

    override suspend fun getPost(id: Int): Response<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun createPost(post: Post): Response<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun updatePost(
        id: Int,
        post: Post
    ): Response<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun patchPost(
        id: Int,
        post: Post
    ): Response<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun deletePost(id: Int): Response<Unit> {
        TODO("Not yet implemented")
    }
}