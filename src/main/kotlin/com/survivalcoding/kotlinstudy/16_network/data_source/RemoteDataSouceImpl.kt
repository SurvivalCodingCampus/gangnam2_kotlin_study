package com.survivalcoding.kotlinstudy.`16_network`.data_source

import com.survivalcoding.kotlinstudy.`16_network`.core.Response
import com.survivalcoding.kotlinstudy.`16_network`.core.toCustomResponse
import com.survivalcoding.kotlinstudy.`16_network`.model.Post
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*


class RemoteDataSouceImpl(
    private val client: HttpClient
) : RemoteDataSource {

    private val baseUrl = "https://jsonplaceholder.typicode.com"

    override suspend fun getPosts(): Response<List<Post>> {
        val response: HttpResponse = client.get("$baseUrl/posts")
        return response.toCustomResponse()
    }

    override suspend fun getPost(id: Int): Response<Post> {
        val response: HttpResponse = client.get("$baseUrl/posts/$id")
        return response.toCustomResponse()
    }

    override suspend fun createPost(post: Post): Response<Post> {
        val response: HttpResponse = client.post("$baseUrl/posts") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }
        return response.toCustomResponse()
    }

    override suspend fun updatePost(
        id: Int,
        post: Post
    ): Response<Post> {
        val response: HttpResponse = client.put("$baseUrl/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }

        return response.toCustomResponse()
    }

    override suspend fun patchPost(
        id: Int,
        post: Post
    ): Response<Post> {
        val response: HttpResponse = client.patch("$baseUrl/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }
        return response.toCustomResponse()
    }

    override suspend fun deletePost(id: Int): Response<Unit> {
        val response: HttpResponse = client.delete("$baseUrl/posts/$id")
        return response.toCustomResponse()
    }
}