package _251121_ktor.data_source

import _251121_ktor.core.BASEURL
import _251121_ktor.core.HttpClientFactory
import _251121_ktor.core.Response
import _251121_ktor.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json

class RemoteDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : RemoteDataSource {

    override suspend fun getPosts(): List<Post> {
        val response: Response<String> = client.get(BASEURL).body()
        return Json.decodeFromString(response.body)
    }

    override suspend fun getPost(id: Int): Post {
        val response = client.get("$BASEURL/$id")
        return Json.decodeFromString(response.bodyAsText())
    }

    override suspend fun createPost(newPost: Post): Post {
        val response = client.post(BASEURL) {
            contentType(ContentType.Application.Json)
            setBody(newPost)
        }
        return Json.decodeFromString(response.bodyAsText())
    }

    override suspend fun updatePost(id: Int, updatePost: Post): Post {
        val response = client.put("$BASEURL\$id") {
            contentType(ContentType.Application.Json)
            setBody(updatePost)
        }
        return Json.decodeFromString(response.bodyAsText())

    }

    override suspend fun patchPost(id: Int, updatePost: Post): Post {
        val response = client.patch("$BASEURL\$id") {
            contentType(ContentType.Application.Json)
            setBody(updatePost)
        }
        return Json.decodeFromString(response.bodyAsText())
    }

    override suspend fun deletePost(id: Int) {
        val response = client.delete("$BASEURL\$id")
    }


}