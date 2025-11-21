package com.sesac.practice.day15.datasource

import com.sesac.practice.day15.core.HttpClientFactory
import com.sesac.practice.day15.core.Response
import com.sesac.practice.day15.core.toResponse
import com.sesac.practice.day15.model.Post
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class RemoteDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create(),
    private val baseUrl: String = BASE_URL,
) : RemoteDataSource {

    override suspend fun getPosts(): Response<List<Post>> {
        val httpResponse = client.get("$baseUrl/posts")

        return httpResponse.toResponse()
    }

    override suspend fun getPost(id: Long): Response<Post> {
        val httpResponse = client.get("$baseUrl/posts/$id")

        return httpResponse.toResponse()
    }

    override suspend fun createPost(post: Post): Response<Post> {
        val httpResponse = client.post("$baseUrl/posts") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }

        return httpResponse.toResponse()
    }

    override suspend fun updatePost(id: Long, post: Post): Response<Post> {
        val httpResponse = client.put("$baseUrl/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }

        return httpResponse.toResponse()
    }

    override suspend fun patchPost(id: Long, post: Post): Response<Post> {
        val httpResponse = client.patch("$baseUrl/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }

        return httpResponse.toResponse()
    }

    override suspend fun deletePost(id: Long): Response<Unit> {
        val httpResponse = client.delete("$baseUrl/posts/$id")

        return httpResponse.toResponse()
    }

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}
