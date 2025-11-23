package com.ezlevup.my.day251121.exercise.data_source

import com.ezlevup.my.day251121.exercise.core.Response
import com.ezlevup.my.day251121.exercise.core.toResponse
import com.ezlevup.my.day251121.exercise.model.Post
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json


class RemoteDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
) : RemoteDataSource {
    override suspend fun getPosts(): Response<List<Post>> {
        val httpResponse = client.get("https://jsonplaceholder.typicode.com/posts")
        val body = Json.decodeFromString<List<Post>>(httpResponse.bodyAsText())
        return httpResponse.toResponse<List<Post>>()
    }

    override suspend fun getPosts(id: Int): Response<Post> {
        val httpResponse = client.get("https://jsonplaceholder.typicode.com/posts/$id")
        val body = Json.decodeFromString<Post>(httpResponse.bodyAsText())
        return httpResponse.toResponse<Post>()
    }

    override suspend fun createPost(post: Post): Response<Post> {
        val httpResponse = client.post("https://jsonplaceholder.typicode.com/posts")
        val body = Json.decodeFromString<Post>(httpResponse.bodyAsText())
        return httpResponse.toResponse<Post>()
    }

    override suspend fun updatePost(
        id: Int,
        post: Post
    ): Response<Post> {
        val httpResponse = client.post("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val body = Json.decodeFromString<Post>(httpResponse.bodyAsText())
        return httpResponse.toResponse<Post>()
    }

    override suspend fun patchPost(
        id: Int,
        post: Post
    ): Response<Post> {
        val httpResponse = client.patch("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val body = Json.decodeFromString<Post>(httpResponse.bodyAsText())
        return httpResponse.toResponse<Post>()
    }

    override suspend fun deletePost(id: Int): Boolean {
        val response = client.delete("https://jsonplaceholder.typicode.com/posts/$id")
        return HttpStatusCode.OK == response.status
    }
}
