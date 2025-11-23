package com.survivalcoding.kotlinstudy.`16_network`.mock

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*


/**
 * RemoteDataSourceImpl 테스트 전용 MockEngine
 * URL + HTTP Method 기준으로 분기
 */

object RemoteDataSourceMockEngine {

    private const val BASE = "https://jsonplaceholder.typicode.com"

    // GET /posts 성공
    fun getPostsSuccess() = MockEngine { request ->
        respond(
            content = ByteReadChannel(
                """
                [
                  {"userId":1, "id":1, "title":"Hello", "body":"Body1"},
                  {"userId":1, "id":2, "title":"World", "body":"Body2"}
                ]
                """.trimIndent()
            ),
            status = HttpStatusCode.OK,
            headers = headersOf("Content-Type", "application/json")
        )
    }

    // GET /post/{id} 성공
    fun getPostSuccess() = MockEngine { request ->
        respond(
            content = ByteReadChannel(
                """
                {"userId":1, "id":1, "title":"Hello", "body":"Body1"}
                """.trimIndent()
            ),
            status = HttpStatusCode.OK,
            headers = headersOf("Content-Type", "application/json")
        )
    }

    // GET /posts/{id} Not Found 실패
    fun getPostNotFound() = MockEngine { request ->
        respond(
            content = ByteReadChannel("{}"),
            status = HttpStatusCode.NotFound,
            headers = headersOf("Content-Type", "application/json")
        )
    }

    // 서버 에러 (모든 요청 강제 500)
    fun serverError() = MockEngine { request ->
        respond(
            content = ByteReadChannel("""{"error":"server error"}"""),
            status = HttpStatusCode.InternalServerError,
            headers = headersOf("Content-Type", "application/json")
        )
    }

    // POST /posts 성공
    fun createPostSuccess() = MockEngine { request ->
        respond(
            content = ByteReadChannel(
                """
                {"userId":1, "id":101, "title":"Created", "body":"CreatedBody"}
                """.trimIndent()
            ),
            status = HttpStatusCode.Created,
            headers = headersOf("Content-Type", "application/json")
        )
    }

    // PUT /posts/{id} 성공
    fun updatePostSuccess() = MockEngine { request ->
        respond(
            content = ByteReadChannel(
                """
                {"userId":1, "id":1, "title":"Updated", "body":"UpdatedBody"}
                """.trimIndent()
            ),
            status = HttpStatusCode.OK,
            headers = headersOf("Content-Type", "application/json")
        )
    }

    // PATCH /posts/{id} 성공
    fun patchPostSuccess() = MockEngine { request ->
        respond(
            content = ByteReadChannel(
                """
                {"userId":1, "id":1, "title":"Patched", "body":"Body1"}
                """.trimIndent()
            ),
            status = HttpStatusCode.OK,
            headers = headersOf("Content-Type", "application/json")
        )
    }

    // DELETE /posts/{id} 성공
    fun deletePostSuccess() = MockEngine { request ->
        respond(
            content = ByteReadChannel(""),
            status = HttpStatusCode.OK
        )
    }
}