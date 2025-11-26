package com.luca.kotlinstudy._16_http.datasource

import com.luca.kotlinstudy.core.Response
import com.luca.kotlinstudy._16_http.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.util.toMap
import kotlinx.serialization.json.Json


class RemoteDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : RemoteDataSource {

    private val baseUrl = "https://jsonplaceholder.typicode.com/posts"

    override suspend fun getPosts(): Response<List<Post>> {
        val response = client.get(baseUrl)
        val posts: List<Post> = Json.decodeFromString(response.bodyAsText())

        return Response(response.status.value, response.headers.toMap(), posts)
    }


    override suspend fun getPost(id: Int): Response<Post?> {
        val response = client.get("$baseUrl/$id")
        val text = response.bodyAsText()

        return if (response.status.isSuccess()) {
            // 200대일 때만 Post로 파싱
            val post: Post = Json.decodeFromString(text)
            Response(response.status.value, response.headers.toMap(), post)
        } else {
            // 404, 500 이런 건 null 반환
            Response(response.status.value, response.headers.toMap(), null)
        }
    }


    override suspend fun createPost(post: String): Response<Post?> {
        val response = client.post(baseUrl) {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val created: Post = Json.decodeFromString(response.bodyAsText())

        return Response(response.status.value, response.headers.toMap(), created)
    }

    override suspend fun updatePost(id: Int, post: Post): Response<Post?> {
        val response = client.put("$baseUrl/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val updated: Post = Json.decodeFromString(response.bodyAsText())

        return Response(response.status.value, response.headers.toMap(), updated)
    }

    override suspend fun patchPost(id: Int, post: Post): Response<Post?> {
        val response = client.patch("$baseUrl/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val patched: Post = Json.decodeFromString(response.bodyAsText())

        return Response(response.status.value, response.headers.toMap(), patched)
    }

    override suspend fun deletePost(id: Int): Response<Unit?> {
        val response = client.delete("$baseUrl/$id")

        return Response(response.status.value, response.headers.toMap(), null)
    }
}
