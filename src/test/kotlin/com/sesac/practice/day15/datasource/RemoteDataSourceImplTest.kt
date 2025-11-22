package com.sesac.practice.day15.datasource

import com.sesac.practice.day15.model.Post
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.network.sockets.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class RemoteDataSourceImplTest {

    private val baseUrl = "https://test.com"
    private val invalidUrl = "https://invalid.com"
    private val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            "$baseUrl/posts" -> {
                when (request.method) {
                    HttpMethod.Get -> {
                        respond(
                            Json.encodeToString<List<Post>>(
                                listOf(
                                    Post(1, 1, "title", "body"),
                                    Post(1, 2, "title2", "body2"),
                                ),
                            ),
                            HttpStatusCode.OK,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    HttpMethod.Post -> {
                        respond(
                            Json.encodeToString<Post>(
                                Post(1, 1, "title", "body"),
                            ),
                            HttpStatusCode.Created,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    else -> {
                        throw IllegalArgumentException("잘못된 요청입니다.")
                    }
                }
            }

            "$baseUrl/posts/1" -> {
                when (request.method) {
                    HttpMethod.Get -> {
                        respond(
                            Json.encodeToString<Post>(
                                Post(1, 1, "title", "body"),
                            ),
                            HttpStatusCode.OK,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    HttpMethod.Put -> {
                        respond(
                            Json.encodeToString<Post>(
                                Post(1, 1, "title2", "body2"),
                            ),
                            HttpStatusCode.OK,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    HttpMethod.Patch -> {
                        respond(
                            Json.encodeToString<Post>(
                                Post(1, 1, "title2", "body"),
                            ),
                            HttpStatusCode.OK,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    HttpMethod.Delete -> {
                        respond(
                            "{}",
                            HttpStatusCode.OK,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    else -> {
                        throw IllegalArgumentException("잘못된 요청입니다.")
                    }
                }
            }

            "$baseUrl/posts/2" -> {
                when (request.method) {
                    HttpMethod.Get -> {
                        respond(
                            "{}",
                            HttpStatusCode.NoContent,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    HttpMethod.Put -> {
                        respond(
                            "{}",
                            HttpStatusCode.NoContent,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    HttpMethod.Patch -> {
                        respond(
                            "{}",
                            HttpStatusCode.NoContent,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    HttpMethod.Delete -> {
                        respond(
                            "{}",
                            HttpStatusCode.NoContent,
                            headersOf(HttpHeaders.ContentType, "application/json"),
                        )
                    }

                    else -> {
                        throw IllegalArgumentException("잘못된 요청입니다.")
                    }
                }
            }

            "$invalidUrl/posts" -> {
                throw ConnectTimeoutException("시간초과입니다.")
            }

            else -> {
                throw IllegalArgumentException("잘못된 요청입니다.")
            }
        }
    }
    private val httpClient = HttpClient(mockEngine) {
        install(ContentNegotiation) { json() }
    }
    private val dataSource = RemoteDataSourceImpl(httpClient, baseUrl)

    @Test
    fun `Post 리스트를 가져온다`() = runTest {
        // given // when
        val response = dataSource.getPosts()

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertEquals(2, response.body?.size)
    }

    @Test
    fun `Post를 가져온다`() = runTest {
        // given
        val id = 1L

        // when
        val response = dataSource.getPost(id)

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertTrue(response.body is Post)
        assertEquals(1, response.body.userId)
        assertEquals(1, response.body.id)
        assertEquals("title", response.body.title)
        assertEquals("body", response.body.body)
    }

    @Test
    fun `Post를 추가한다`() = runTest {
        // given
        val post = Post(1, 1, "title", "body")

        // when
        val response = dataSource.createPost(post)

        // then
        assertEquals(HttpStatusCode.Created.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertTrue(response.body is Post)
        assertEquals(1, response.body.userId)
        assertEquals(1, response.body.id)
        assertEquals("title", response.body.title)
        assertEquals("body", response.body.body)
    }

    @Test
    fun `Post를 업데이트한다`() = runTest {
        // given
        val id = 1L
        val post = Post(1, id, "title2", "body2")

        // when
        val response = dataSource.updatePost(id, post)

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertTrue(response.body is Post)
        assertEquals(1, response.body.userId)
        assertEquals(1, response.body.id)
        assertEquals("title2", response.body.title)
        assertEquals("body2", response.body.body)
    }

    @Test
    fun `Post를 부분 업데이트한다`() = runTest {
        // given
        val id = 1L
        val post = Post(1, id, "title2", "body")

        // when
        val response = dataSource.patchPost(id, post)

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertTrue(response.body is Post)
        assertEquals(1, response.body.userId)
        assertEquals(1, response.body.id)
        assertEquals("title2", response.body.title)
        assertEquals("body", response.body.body)
    }

    @Test
    fun `Post를 삭제한다`() = runTest {
        // given
        val id = 1L

        // when
        val response = dataSource.deletePost(id)

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertNull(response.body)
    }

    @Test(expected = ConnectTimeoutException::class)
    fun `네트워크 오류시 에러가 발생한다`() = runTest {
        // given
        val dataSourceImpl = RemoteDataSourceImpl(httpClient, invalidUrl)

        // when // then
        dataSourceImpl.getPosts()
    }

    @Test
    fun `존재하지 않는 ID로 조회 시 NoContent 받는다`() = runTest {
        // given
        val id = 2L

        // when
        val response = dataSource.getPost(id)

        // then
        assertEquals(HttpStatusCode.NoContent.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertNull(response.body)
    }

    @Test
    fun `존재하지 않는 ID로 업데이트 시 NoContent 받는다`() = runTest {
        // given
        val id = 2L
        val post = Post(1, id, "title2", "body2")

        // when
        val response = dataSource.updatePost(id, post)

        // then
        assertEquals(HttpStatusCode.NoContent.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertNull(response.body)
    }

    @Test
    fun `존재하지 않는 ID로 부분 업데이트 시 NoContent 받는다`() = runTest {
        // given
        val id = 2L
        val post = Post(1, id, "title2", "body2")

        // when
        val response = dataSource.patchPost(id, post)

        // then
        assertEquals(HttpStatusCode.NoContent.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertNull(response.body)
    }

    @Test
    fun `존재하지 않는 ID로 삭제 시 NoContent 받는다`() = runTest {
        // given
        val id = 2L

        // when
        val response = dataSource.deletePost(id)

        // then
        assertEquals(HttpStatusCode.NoContent.value, response.statusCode)
        assertEquals(true, response.headers["Content-Type"]?.first()?.contains("application/json"))
        assertNull(response.body)
    }
}
