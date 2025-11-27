package com.survivalcoding.kotlinstudy.`18_result`.practice.data_source

import com.survivalcoding.kotlinstudy.`18_result`.practice.model.User
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.serialization.json.Json

object UserMockEngine {

    private val mockData: String = UserMockData.json

    private val jsonHeaders = headersOf(
        HttpHeaders.ContentType,
        ContentType.Application.Json.toString()
    )

    val mockEngine: MockEngine = MockEngine { request ->
        val url: String = request.url.toString()

        when {
            url == "https://jsonplaceholder.typicode.com/users" -> {
                when (request.method) {
                    HttpMethod.Get -> {
                        respond(
                            content = ByteReadChannel(mockData),
                            status = HttpStatusCode.OK,
                            headers = jsonHeaders
                        )
                    }

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

            url.startsWith("https://jsonplaceholder.typicode.com/users/") -> {
                val idText: String = url.substringAfterLast("/")
                val id: Int = idText.toInt()

                val users: List<User> = Json.decodeFromString(mockData)
                val user: User? = users.firstOrNull { it.id == id }

                when (request.method) {
                    HttpMethod.Get -> {
                        if (user == null) {
                            respond(
                                content = ByteReadChannel("Error"),
                                status = HttpStatusCode.NotFound,
                                headers = jsonHeaders
                            )
                        } else {
                            val singleJson: String = Json.encodeToString(user)

                            respond(
                                content = ByteReadChannel(singleJson),
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
