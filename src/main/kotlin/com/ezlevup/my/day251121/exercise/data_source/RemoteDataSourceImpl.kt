package com.ezlevup.my.day251121.exercise.data_source

import com.ezlevup.my.day251121.exercise.model.Post
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

data class Response<T>(
    val status: HttpStatusCode,
    val headers: Headers,
    val body: T,
)

class RemoteDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
) : RemoteDataSource {
    override suspend fun getPosts(): Response<List<Post>> {
        val response = client.get("https://jsonplaceholder.typicode.com/posts")
        val body = Json.decodeFromString<List<Post>>(response.bodyAsText())
        return Response(
            status = response.status,
            headers = response.headers,
            body = body,
        )
    }

    override suspend fun getPost(id: Int): Response<Post> {
        val response = client.get("https://jsonplaceholder.typicode.com/posts/$id")
        val body = Json.decodeFromString<Post>(response.bodyAsText())
        return Response(
            status = response.status,
            headers = response.headers,
            body = body,
        )
    }

    override suspend fun createPost(post: Post): Response<Post> {
        val response = client.post("https://jsonplaceholder.typicode.com/posts")
        val body = Json.decodeFromString<Post>(response.bodyAsText())
        return Response(
            status = response.status,
            headers = response.headers,
            body = body,
        )
    }

    override suspend fun updatePost(
        id: Int,
        post: Post
    ): Response<Post> {
        val response = client.post("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val body = Json.decodeFromString<Post>(response.bodyAsText())
        return Response(
            status = response.status,
            headers = response.headers,
            body = body,
        )
    }

    override suspend fun patchPost(
        id: Int,
        post: Post
    ): Response<Post> {
        val response = client.patch("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        val body = Json.decodeFromString<Post>(response.bodyAsText())
        return Response(
            status = response.status,
            headers = response.headers,
            body = body,
        )
    }

    override suspend fun deletePost(id: Int): Boolean {
        val response = client.delete("https://jsonplaceholder.typicode.com/posts/$id")
        return HttpStatusCode.OK == response.status
    }
}
