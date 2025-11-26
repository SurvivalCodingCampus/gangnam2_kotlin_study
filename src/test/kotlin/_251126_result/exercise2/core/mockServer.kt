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


                "http://localhost/clienterror.com" -> {//클라이언트 에러
                    respond(
                        status = HttpStatusCode.NotFound,
                        content = "{}"
                    )
                }

                "http://localhost/servererror.com" -> {//server 에러
                    respond(
                        status = HttpStatusCode.InternalServerError,
                        content = "{}"
                    )
                }

                "http://localhost/pasringerror.com" -> {//파싱 에러
                    respond(
                        status = HttpStatusCode.OK,
                        content = Json.encodeToString(InvalidUserType("서울시"))
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
