package com.survival.kotlinstudy.day16.datasource

import com.survival.kotlinstudy.day16.model.Post
import com.survival.kotlinstudy.day16.model.Response
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json


class RemoteDataSourceImpl(
    private val client: HttpClient
) : RemoteDataSource {
    private fun HttpResponse.toHeaderMap(): Map<String, String> {
        return headers.entries().associate { it.key to it.value.joinToString("; ") }
    }

    override suspend fun getPosts(): Response<List<Post>> {
        val response = client.get(urlString = "https://jsonplaceholder.typicode.com/posts")
        val body = Json.decodeFromString<List<Post>>(response.bodyAsText())


        return Response(header = response.toHeaderMap(), codeStatus = response.status.value, body = body)
    }

    override suspend fun getPost(id: Int): Response<Post> {
        val response = client.get(urlString = "https://jsonplaceholder.typicode.com/posts/$id")
        val body = Json.decodeFromString<Post>(response.bodyAsText())


        return Response(header = response.toHeaderMap(), codeStatus = response.status.value, body = body)
    }

    override suspend fun createPost(post: Post): Response<Post> {
        val response = client.post(urlString = "https://jsonplaceholder.typicode.com/posts") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val body = Json.decodeFromString<Post>(response.bodyAsText())

        return Response(header = response.toHeaderMap(), codeStatus = response.status.value, body = body)
    }

    override suspend fun updatePost(id: Int, post: Post): Response<Post> {
        val response = client.put("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val body = Json.decodeFromString<Post>(response.bodyAsText())


        return Response(header = response.toHeaderMap(), codeStatus = response.status.value, body = body)
    }

    override suspend fun patchPost(id: Int, post: Post): Response<Post> {
        val response = client.patch("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val body = Json.decodeFromString<Post>(response.bodyAsText())

        return Response(header = response.toHeaderMap(), codeStatus = response.status.value, body = body)
    }

    override suspend fun deletePost(id: Int): Response<Post> {
        val response = client.delete("https://jsonplaceholder.typicode.com/posts/$id")

        return Response(header = response.toHeaderMap(), codeStatus = response.status.value, body = null)
    }
}