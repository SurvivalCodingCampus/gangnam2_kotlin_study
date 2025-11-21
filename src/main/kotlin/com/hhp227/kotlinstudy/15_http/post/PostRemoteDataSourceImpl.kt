package com.hhp227.kotlinstudy.`15_http`.post

import com.hhp227.kotlinstudy.`15_http`.Response
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
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
        val response = client.get(URL)
        return Response(
            response.status.value,
            response.headers,
            response.body()
        )
    }

    override suspend fun getPost(id: Int): Response<Post?> {
        val response = client.get("$URL/$id")
        return if (!response.status.isSuccess()) {
            Response(response.status.value, response.headers, null)
        } else {
            Response(
                response.status.value,
                response.headers,
                response.body()
            )
        }
    }

    override suspend fun createPost(post: Post): Response<Post?> {
        val response = client.post(URL) {
            contentType(ContentType.Application.Json)
            setBody(post)
        }
        return if (!response.status.isSuccess()) {
            Response(response.status.value, response.headers, null)
        } else Response(
            response.status.value,
            response.headers,
            response.body()
        )
    }

    override suspend fun updatePost(id: Int, post: Post): Response<Post?> {
        val response = client.put("$URL/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }
        return if (!response.status.isSuccess()) {
            Response(response.status.value, response.headers, null)
        } else {
            Response(
                response.status.value,
                response.headers,
                response.body()
            )
        }
    }

    override suspend fun patchPost(id: Int, post: Post): Response<Post?> {
        val response = client.patch("$URL/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }
        return if (!response.status.isSuccess()) {
            Response(response.status.value, response.headers, null)
        } else Response(
            response.status.value,
            response.headers,
            response.body()
        )
    }

    override suspend fun deletePost(id: Int): Response<Boolean> {
        val response = client.delete("$URL/$id")
        return if (!response.status.isSuccess()) {
            Response(response.status.value, response.headers, false)
        } else Response(
            response.status.value,
            response.headers,
            true
        )
    }

    companion object {
        const val URL = "https://jsonplaceholder.typicode.com/posts"
    }
}