package com.survivalcoding.kotlinstudy.`18_result`.practice.data_source

import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.ByteReadChannel

object NetworkErrorMockEngine {

    private val mockData: String = UserMockData.json

    private val jsonHeaders = headersOf(
        HttpHeaders.ContentType,
        ContentType.Application.Json.toString()
    )

    val mockEngine: MockEngine = MockEngine { request: HttpRequestData ->
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
                        error("MockEngine: /users 엔드포인트에서 지원하지 않는 HTTP 메서드입니다. method=${request.method}")
                    }
                }
            }

            url.startsWith("https://jsonplaceholder.typicode.com/users/") -> {
                val idText: String = url.substringAfterLast("/")
                val id: Int = idText.toInt()

                val status: HttpStatusCode = when (id) {
                    1 -> HttpStatusCode.BadRequest
                    2 -> HttpStatusCode.InternalServerError
                    else -> HttpStatusCode.MultipleChoices
                }

                respondError(
                    status = status,
                    headers = jsonHeaders

                )
            }

            else -> {
                respondError(
                    status = HttpStatusCode.NotFound,
                    headers = jsonHeaders
                )
            }
        }
    }
}
