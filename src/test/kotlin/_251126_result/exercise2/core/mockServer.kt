package _251126_result.exercise2.core

import _251126_result.exercise2.model.User
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.http.HttpMethod.Companion.Get
import io.ktor.http.HttpMethod.Companion.Post
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

val mockEngine = MockEngine { request ->
    when (request.method) {
        Get -> {
            when (request.url.toString()) {
                "http://localhost/test.com" -> {
                    respond(
                        status = HttpStatusCode.OK,
                        content = """[{"name":"홍길동","age":43,"id":1}]"""
                    )
                }

                "http://localhost/test/2.com" -> {
                    respond(
                        status = HttpStatusCode.OK,
                        content = """{"name":"홍길동","age":43,"id":2}"""
                    )
                }

                "http://localhost/test/4.com" -> {
                    respond(
                        status = HttpStatusCode.BadRequest,
                        content = "{}"
                    )
                }

                "http://localhost/test/5.com" -> {
                    respond(
                        status = HttpStatusCode.InternalServerError,
                        content = "{}"
                    )
                }

                "http://localhost/testall.com" -> {
                    respond(
                        status = HttpStatusCode.OK,
                        content = """[{"name":"홍길동","age":43,"id":1},{"name":"이순신","age":22,"id":2},{"name":"흥부","age":43,"id":3}]"""
                    )
                }

                "http://localhost/timeout.com" -> {//timeout
                    delay(11_000L)
                    respond(
                        status = HttpStatusCode.OK,
                        content = Json.encodeToString(User(name = "홍길동", age = 43, id = 1))
                    )
                }

                else -> {
                    respond(
                        status = HttpStatusCode.BadRequest,
                        content = "{}"
                    )
                }
            }
        }

        Post -> {
            when (request.url.toString()) {
                "http://localhost/test.com" -> {
                    respond(
                        status = HttpStatusCode.OK,
                        content = HttpStatusCode.OK.toString()
                    )
                }

                else -> {
                    respond(
                        status = HttpStatusCode.NotFound,
                        content = HttpStatusCode.NotFound.toString()
                    )
                }
            }

        }

        else -> {
            respond(
                status = HttpStatusCode.NotFound,
                content = "{}"
            )
        }
    }
}

data class InvalidUserType(
    val address: String
)
