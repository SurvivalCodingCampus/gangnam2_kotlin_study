package com.survivalcoding.kotlinstudy.`14_http_exam`.data_source

import Post
import com.survivalcoding.kotlinstudy.core.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class JsonPlaceHolderDataSourceImpl(
    private val httpClient: HttpClient = HttpClientFactory.create()
) : RemoteDataSource {

    override suspend fun getPosts(): List<Post> {
        val response = httpClient.get("$BASE_URL/posts")
        val jsonBodyString = response.bodyAsText()
        return Json.decodeFromString(jsonBodyString)
    }

    override suspend fun getPost(id: Long): Post? {
        val response = httpClient.get("$BASE_URL/posts/$id")

        if (response.status == HttpStatusCode.NotFound) {
            return null
        }

        val jsonBodyString = response.bodyAsText()
        return Json.decodeFromString(jsonBodyString)
    }

    override suspend fun createPost(post: Post): Post? {
        val jsonString = Json.encodeToString(post)

        val response = httpClient.post("$BASE_URL/posts") {
            contentType(ContentType.Application.Json)
            setBody(jsonString)
        }

        if (response.status != HttpStatusCode.Created) {
            return null
        }

        val jsonBodyString = response.bodyAsText()
        return Json.decodeFromString(jsonBodyString)
    }

    override suspend fun updatePost(id: Long, post: Post): Post? {
        val response = httpClient.put("$BASE_URL/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        if (response.status != HttpStatusCode.OK) {
            return null
        }

        val jsonBodyString = response.bodyAsText()
        return Json.decodeFromString(jsonBodyString)
    }

    override suspend fun patchPost(id: Long, post: Post): Post? {
        val response = httpClient.patch("$BASE_URL/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(post))
        }

        if (response.status != HttpStatusCode.OK) {
            return null
        }

        val jsonBodyString = response.bodyAsText()
        return Json.decodeFromString(jsonBodyString)
    }

    override suspend fun deletePost(id: Long) {
        httpClient.delete("$BASE_URL/posts/$id")
    }


    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}