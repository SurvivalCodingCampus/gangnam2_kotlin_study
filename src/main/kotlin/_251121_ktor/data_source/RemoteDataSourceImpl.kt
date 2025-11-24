package _251121_ktor.data_source

import _251121_ktor.core.BASEURL
import _251121_ktor.core.HttpClientFactory
import _251121_ktor.model.Post
import _251121_ktor.model.Response
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class RemoteDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : RemoteDataSource {

    override suspend fun getPosts(): Response<List<Post>> {
        val response = client.get(BASEURL)
        return Response(body = Json.decodeFromString(response.bodyAsText()), statusCode = response.status.toString())
    }

    override suspend fun getPost(id: Int): Response<Post> {
        val response = client.get("$BASEURL/$id")
        return Response(body = Json.decodeFromString(response.bodyAsText()), statusCode = response.status.toString())
    }

    override suspend fun createPost(newPost: Post): Response<Post> {
        val response = client.post(BASEURL) {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(newPost.toString()))
        }
        return Response(body = Json.decodeFromString(response.bodyAsText()), statusCode = response.status.toString())
    }

    override suspend fun updatePost(id: Int, updatePost: Post): Response<Post> {
        val response = client.put("$BASEURL/$id") {
            contentType(ContentType.Application.Json)
            setBody(updatePost)
        }
        return Response(body = Json.decodeFromString(response.bodyAsText()), statusCode = response.status.toString())

    }

    override suspend fun patchPost(id: Int, updatePost: Post): Response<Post> {
        val response = client.patch("$BASEURL/$id") {
            contentType(ContentType.Application.Json)
            setBody(updatePost)
        }
        return Response(body = Json.decodeFromString(response.bodyAsText()), statusCode = response.status.toString())
    }

    override suspend fun deletePost(id: Int): HttpStatusCode {
        val response = client.delete("$BASEURL/$id")
        return response.status
    }


}