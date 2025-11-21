package com.hhp227.kotlinstudy.`15_http`.post

import com.hhp227.kotlinstudy.`15_http`.Response
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PostRemoteDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }
) : PostRemoteDataSource {
    override suspend fun getPosts(): Response<List<Post>> {
        val response = client.get("https://jsonplaceholder.typicode.com/posts")
        return Response(
            response.status.value,
            response.headers,
            Json.decodeFromString(response.bodyAsText())
        )
    }

    override suspend fun getPost(id: Int): Response<Post?> {
        val response = client.get("https://jsonplaceholder.typicode.com/posts/$id")
        return if (!response.status.isSuccess()) {
            Response(response.status.value, response.headers, null)
        } else {
            Response(
                response.status.value,
                response.headers,
                Json.decodeFromString(response.bodyAsText())
            )
        }
    }

    override suspend fun createPost(post: Post): Response<Post> {
        val response = client.post("https://jsonplaceholder.typicode.com/posts") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }
        return Response(
            response.status.value,
            response.headers,
            Json.decodeFromString(response.bodyAsText())
        )
    }

    override suspend fun updatePost(id: Int, post: Post): Response<Post?> {
        val response = client.put("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }
        return if (!response.status.isSuccess()) {
            Response(response.status.value, response.headers, null)
        } else {
            Response(
                response.status.value,
                response.headers,
                Json.decodeFromString(response.bodyAsText())
            )
        }
    }

    override suspend fun patchPost(id: Int, post: Post): Response<Post> {
        val response = client.patch("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }
        return Response(
            response.status.value,
            response.headers,
            Json.decodeFromString(response.bodyAsText())
        )
    }

    override suspend fun deletePost(id: Int): Response<Boolean> {
        val response = client.delete("https://jsonplaceholder.typicode.com/posts/$id")
        return Response(
            response.status.value,
            response.headers,
            true
        )
    }
}