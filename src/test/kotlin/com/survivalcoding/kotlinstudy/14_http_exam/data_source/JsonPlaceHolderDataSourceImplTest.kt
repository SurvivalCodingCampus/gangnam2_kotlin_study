package com.survivalcoding.kotlinstudy.`14_http_exam`.data_source

import Post
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals

class JsonPlaceHolderDataSourceImplTest {

    private val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            // getPosts()
            "https://jsonplaceholder.typicode.com/posts" -> {
                // body가 있는 POST 요청
                if (request.body.contentType == ContentType.Application.Json) {
                    respond(
                        content = CREATE_POST,
                        status = HttpStatusCode.Created,
                        headers = headersOf("Content-Type", "application/json"),
                    )
                } else {    // body가 없는 GET 요청
                    respond(
                        content = POSTS_ALL,
                        status = HttpStatusCode.OK,
                        headers = headersOf("Content-Type", "application/json"),
                    )
                }
            }

            // getPost(id)
            "https://jsonplaceholder.typicode.com/posts/1" -> {
                respond(
                    content = POST_1,
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type", "application/json"),
                )
            }

            // updatePost(id, post)
            "https://jsonplaceholder.typicode.com/posts/10" -> {
                respond(
                    content = UPDATE_POST,
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type", "application/json"),
                )
            }

            // patchPost(id, post)
            "https://jsonplaceholder.typicode.com/posts/20" -> {
                respond(
                    content = PATCH_POST,
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type", "application/json"),
                )
            }

            // deletePost(id)
            "https://jsonplaceholder.typicode.com/posts/80" -> {
                respond(
                    content = "",
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type", "application/json"),
                )
            }

            // 존재하지 않는 ID 요청 케이스
            "https://jsonplaceholder.typicode.com/posts/200" -> {
                respond(
                    content = "{}",
                    status = HttpStatusCode.NotFound,
                )
            }

            // 네트워크 에러 케이스
            else -> {
                respond(
                    content = "{}",
                    status = HttpStatusCode.BadGateway,
                )
            }
        }
    }
    private val mockClient = HttpClient(mockEngine)
    private val dataSource: RemoteDataSource = JsonPlaceHolderDataSourceImpl(mockClient)

    @Test
    fun getPosts() = runTest {
        val posts = dataSource.getPosts()

        assertEquals(Json.decodeFromString(POSTS_ALL), posts)
    }

    @Test
    fun getPost() = runTest {
        val post = dataSource.getPost(1)

        assertEquals(Json.decodeFromString(POST_1), post)
    }


    @Test
    fun createPost() = runTest {
        val expected = Json.decodeFromString<Post>(CREATE_POST)
        val post = dataSource.createPost(expected)

        assertEquals(expected, post)
    }

    @Test
    fun updatePost() = runTest {
        val expected = Json.decodeFromString<Post>(UPDATE_POST)
        val result = dataSource.updatePost(10, expected)

        assertEquals(expected, result)
    }

    @Test
    fun patchPost() = runTest {
        val expected = Json.decodeFromString<Post>(PATCH_POST)
        val result = dataSource.patchPost(20, expected)

        assertEquals(expected, result)
    }

}