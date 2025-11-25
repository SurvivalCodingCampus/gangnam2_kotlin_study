package com.survivalcoding.kotlinstudy.`16_http`.practice.post.data_source

import com.survivalcoding.kotlinstudy.`16_http`.practice.model.Post
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.serialization.json.Json

object PostMockEngine {

    private val mockData: String = HttpMockData.json

    private val jsonHeaders = headersOf(
        HttpHeaders.ContentType,
        ContentType.Application.Json.toString()
    )

    val mockEngine: MockEngine = MockEngine { request ->
        val url: String = request.url.toString()

        when {
            url == "https://jsonplaceholder.typicode.com/posts" -> {
                when (request.method) {
                    // getPost()
                    HttpMethod.Get -> {
                        respond(
                            content = ByteReadChannel(mockData),
                            status = HttpStatusCode.OK,
                            headers = jsonHeaders
                        )
                    }

                    // createPost(post)
                    HttpMethod.Post -> {
                        val bodyJson: String = request.body.toByteArray().decodeToString()

                        respond(
                            content = ByteReadChannel(bodyJson),
                            status = HttpStatusCode.Created,
                            headers = jsonHeaders
                        )
                    }

                    else -> {
                        error("MockEngine: /posts 엔드포인트에서 지원하지 않는 HTTP 메서드입니다. method=${request.method}")
                    }
                }
            }

            url.startsWith("https://jsonplaceholder.typicode.com/posts/") -> {
                val idText: String = url.substringAfterLast("/")
                val id: Int = idText.toInt()

                val posts: List<Post> = Json.decodeFromString(mockData)
                val post: Post? = posts.firstOrNull { it.id == id }

                when (request.method) {
                    // getPost(id)
                    HttpMethod.Get -> {
                        if (post == null) {
                            respond(
                                content = ByteReadChannel("Error"),
                                status = HttpStatusCode.NotFound,
                                headers = jsonHeaders
                            )
                        } else {
                            val singleJson: String = Json.encodeToString(post)

                            respond(
                                content = ByteReadChannel(singleJson),
                                status = HttpStatusCode.OK,
                                headers = jsonHeaders
                            )
                        }
                    }

                    // updatePost(id, post)
                    HttpMethod.Put -> {
                        val bodyJson: String = request.body.toByteArray().decodeToString()

                        if (post == null) {
                            respond(
                                content = ByteReadChannel("Error"),
                                status = HttpStatusCode.NotFound,
                                headers = jsonHeaders
                            )
                        } else {
                            respond(
                                content = ByteReadChannel(bodyJson),
                                status = HttpStatusCode.OK,
                                headers = jsonHeaders
                            )
                        }
                    }

                    // patchPost(id, post)
                    HttpMethod.Patch -> {
                        val bodyJson: String = request.body.toByteArray().decodeToString()

                        if (post == null) {
                            respond(
                                content = ByteReadChannel("Error"),
                                status = HttpStatusCode.NotFound,
                                headers = jsonHeaders
                            )
                        } else {
                            respond(
                                content = ByteReadChannel(bodyJson),
                                status = HttpStatusCode.OK,
                                headers = jsonHeaders
                            )
                        }
                    }

                    // deletePost(id)
                    HttpMethod.Delete -> {
                        if (post == null) {
                            respond(
                                content = ByteReadChannel("Error"),
                                status = HttpStatusCode.NotFound,
                                headers = jsonHeaders
                            )
                        } else {
                            respond(
                                content = ByteReadChannel(""),
                                status = HttpStatusCode.OK,
                                headers = jsonHeaders
                            )
                        }
                    }

                    else -> {
                        error("MockEngine: /posts/$id 엔드포인트에서 지원하지 않는 HTTP 메서드입니다. method=${request.method}")
                    }
                }
            }

            else -> {
                error("MockEngine: 처리되지 않은 URL입니다. url=$url")
            }
        }
    }
}
