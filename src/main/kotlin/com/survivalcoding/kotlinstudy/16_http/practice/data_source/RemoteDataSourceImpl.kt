package com.survivalcoding.kotlinstudy.`16_http`.practice.data_source

import com.survivalcoding.kotlinstudy.`16_http`.practice.HttpClientFactory
import com.survivalcoding.kotlinstudy.`16_http`.practice.model.Post
import com.survivalcoding.kotlinstudy.repository.core.Response
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.serialization.json.Json

class RemoteDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.creat()
) : RemoteDataSource {
    private val json = Json { explicitNulls = false }

    private suspend inline fun <reified T> parseSuccess(response: HttpResponse): Response<T> {
        val text: String = response.bodyAsText()

        if (!response.status.isSuccess()) {
            throw IllegalStateException("HTTP ${response.status.value}: $text")
        }

        val body: T = json.decodeFromString(text)

        return Response(
            statusCode = response.status.value,
            header = response.headers.toMap(),
            body = body
        )
    }

    override suspend fun getPost(): Response<List<Post>> {
        val response: HttpResponse =
            client.get("https://jsonplaceholder.typicode.com/posts")

        return parseSuccess(response)
    }

    override suspend fun getPost(id: Int): Response<Post> {
        val response: HttpResponse =
            client.get("https://jsonplaceholder.typicode.com/posts/$id")

        return parseSuccess(response)
    }

    override suspend fun createPost(post: Post): Response<Post> {
        val response: HttpResponse =
            client.post("https://jsonplaceholder.typicode.com/posts") {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(post))
            }

        return parseSuccess(response)
    }

    override suspend fun updatePost(
        id: Int,
        post: Post
    ): Response<Post> {
        val response: HttpResponse =
            client.put("https://jsonplaceholder.typicode.com/posts/$id") {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(post))
            }

        return parseSuccess(response)
    }

    override suspend fun patchPost(
        id: Int,
        post: Post
    ): Response<Post> {
        val response: HttpResponse =
            client.patch("https://jsonplaceholder.typicode.com/posts/$id") {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(post))
            }

        return parseSuccess(response)
    }

    override suspend fun deletePost(id: Int): Response<Unit> {
        val response: HttpResponse =
            client.delete("https://jsonplaceholder.typicode.com/posts/$id")

        return parseSuccess(response)
    }
}