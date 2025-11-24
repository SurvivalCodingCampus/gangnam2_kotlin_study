package _251121_ktor.exercise1to3.data_source

import _251121_ktor.exercise1to3.core.BASEURL
import _251121_ktor.exercise1to3.core.POSTSJSON
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.http.HttpMethod.Companion.Delete
import io.ktor.http.HttpMethod.Companion.Get
import io.ktor.http.HttpMethod.Companion.Patch
import io.ktor.http.HttpMethod.Companion.Post
import io.ktor.http.HttpMethod.Companion.Put

val mockEngine = MockEngine { request ->
    when (request.method) {
        Get -> {
            val rawSegments = request.url.rawSegments // /(슬래시)를 기준으로 자른 것을 리스트로 반환
            if (request.url.toString() == BASEURL) {
                respond(
                    content = POSTSJSON,
                    status = HttpStatusCode.OK
                )
            } else if (rawSegments.size == 3 && rawSegments[1] == "posts") {
                val id = rawSegments[2].toIntOrNull()
                when (id) {
                    in 1..100 -> {
                        respond(
                            content = """{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
  }""",
                            status = HttpStatusCode.OK
                        )
                    }

                    else -> {
                        respond(
                            content = "{}", // 문제의 빈 JSON 응답 본문
                            status = HttpStatusCode.NotFound, // 404 상태 코드
                        )
                    }
                }
            } else {
                respond(
                    content = "{}", // 문제의 빈 JSON 응답 본문
                    status = HttpStatusCode.NotFound, // 404 상태 코드
                )
            }
        }

        Post -> {
            when (request.url.toString()) {
                BASEURL -> {
                    respond(
                        content = """{ "body" : "testPost", "title" : "test", "userId" : 100, "id" : 101 }""",
                        status = HttpStatusCode.OK,
                        headers = headersOf(HttpHeaders.ContentType, "application/json")


                    )
                }

                else -> {
                    respond(
                        content = "{}",
                        status = HttpStatusCode.NotFound
                    )
                }
            }
        }

        Put -> {
            when (request.url.toString()) {
                "${BASEURL}/1" -> {
                    respond(
                        content = """{ "body" : "after", "title" : "test", "userId" : 1, "id" : 1}""",
                        status = HttpStatusCode.OK
                    )
                }

                else -> {
                    respond(
                        content = "{}",
                        status = HttpStatusCode.NotFound
                    )
                }
            }
        }

        Patch -> {
            when (request.url.toString()) {
                "${BASEURL}/1" -> {
                    respond(
                        content = """{ "body" : "after", "title" : "test", "userId" : 1, "id" : 1}""",
                        status = HttpStatusCode.OK
                    )
                }

                else -> {
                    respond(
                        content = "{}",
                        status = HttpStatusCode.NotFound
                    )
                }
            }

        }

        Delete -> {
            val rawSegments = request.url.rawSegments // /(슬래시)를 기준으로 자른 것을 리스트로 반환
            val id = rawSegments[2].toIntOrNull()

            when (id) {
                5 -> {
                    respond(
                        content = """{}""",
                        status = HttpStatusCode.InternalServerError
                    )
                }

                in 1..100 -> {
                    respond(
                        content = """{}""",
                        status = HttpStatusCode.OK
                    )
                }

                else -> {
                    respond(
                        content = "[]",
                        status = HttpStatusCode.NotFound
                    )
                }
            }
        }

        else -> {
            respond(
                content = "[]",
                status = HttpStatusCode.NotFound
            )
        }
    }
}
