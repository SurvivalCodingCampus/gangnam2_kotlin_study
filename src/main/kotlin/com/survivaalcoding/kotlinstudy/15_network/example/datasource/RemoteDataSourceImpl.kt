package com.survivaalcoding.kotlinstudy.`15_network`.example.datasource

import com.survivaalcoding.kotlinstudy.`15_network`.example.core.Response
import com.survivaalcoding.kotlinstudy.`15_network`.example.model.Post
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.serialization.json.Json

class RemoteDataSourceImpl(val httpClient: HttpClient = HttpClient(CIO)) : RemoteDataSource {
    override suspend fun getPosts(): Response<List<Post>> {
        val response = getHttpClient(BASE_URL)

        val body = if (response.status.isSuccess()) getBody<List<Post>>(response) else emptyList()

        return Response(getHeaders(response.headers), getStatusCode(response.status), body)
    }

    override suspend fun getPost(id: Long): Response<Post?> {
        val response = getHttpClient("$BASE_URL/$id")

        val body = if (response.status.isSuccess()) getBody<Post>(response) else null

        return Response(getHeaders(response.headers), getStatusCode(response.status), body)
    }

    override suspend fun createPost(post: Post): Response<Post> {
        val body = getJsonData(post)

        val response = httpClient.post(BASE_URL) {
            contentType(ContentType.Application.Json)
            setBody(body)
        }

        return Response(getHeaders(response.headers), getStatusCode(response.status), getBody(response))
    }

    override suspend fun updatePost(
        id: Long,
        post: Post
    ): Response<Post> {
        val body = getJsonData(post)

        val response = httpClient.put("$BASE_URL/$id") {
            contentType(ContentType.Application.Json)
            setBody(body)
        }

        return Response(getHeaders(response.headers), getStatusCode(response.status), getBody(response))
    }

    override suspend fun patchPost(
        id: Long,
        post: Post
    ): Response<Post> {
        val body = getJsonData(post)

        val response = httpClient.patch("$BASE_URL/$id") {
            contentType(ContentType.Application.Json)
            setBody(body)
        }

        return Response(getHeaders(response.headers), getStatusCode(response.status), getBody(response))
    }

    override suspend fun deletePost(id: Long): Response<Unit> {
        val response = httpClient.delete("$BASE_URL/$id")

        return Response(getHeaders(response.headers), getStatusCode(response.status), getBody(response))
    }

    private suspend fun getHttpClient(url: String): HttpResponse = httpClient.get(url)

    private fun getHeaders(headers: Headers): Map<String, List<String>> = headers.toMap()

    private fun getStatusCode(status: HttpStatusCode): Int = status.value

    private suspend inline fun <reified T> getBody(response: HttpResponse): T =
        try {
            Json.decodeFromString(response.bodyAsText())
        } catch (e: Exception) {
            throw IllegalStateException("응답 파싱 실패: ${e.message}", e)
        }

    private fun getJsonData(post: Post): String = Json.encodeToString(post)

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/posts"
    }
}