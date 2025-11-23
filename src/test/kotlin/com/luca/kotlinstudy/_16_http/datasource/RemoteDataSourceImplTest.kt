package com.luca.kotlinstudy._16_http.datasource

import com.luca.kotlinstudy._16_http.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.*
import io.ktor.http.headersOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlinx.io.IOException
import org.junit.Assert.*
import org.junit.Test

class RemoteDataSourceImplTest {

    private val postJson =
        """{"id":1,"title":"Hello","body":"World","ussrId":1}"""

    private val postsJson =
        """
        [
          {"id":1,"title":"Hello","body":"World","ussrId":1},
          {"id":2,"title":"Foo","body":"Bar","ussrId":2}
        ]
        """

    private fun mockClient(engine: MockEngine) = HttpClient(engine)

    // getPosts()
    @Test
    fun `getPosts 성공`() = runBlocking {

        // MockEngine: URL 기준으로 응답 분기
        val engine = MockEngine { request ->
            when (request.url.toString()) {

                // 전체 posts 조회
                "https://jsonplaceholder.typicode.com/posts" -> respond(
                    content = postsJson,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )

                else -> respond(
                    content = """[]""",
                    status = HttpStatusCode.NotFound,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            }
        }

        val dataSource = RemoteDataSourceImpl(mockClient(engine))

        val response = dataSource.getPosts()

        assertEquals(200, response.statusCode)
        assertEquals(2, response.body!!.size)
        assertEquals("Hello", response.body!![0].title)
    }


    // getPost()
    @Test
    fun `getPost 성공 - 단일 게시글`() = runBlocking {

        val engine = MockEngine { request ->
            when (request.url.toString()) {

                "https://jsonplaceholder.typicode.com/posts/1" -> respond(
                    content = postJson,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )

                else -> respond(
                    content = """{"error":"not found"}""",
                    status = HttpStatusCode.NotFound,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            }
        }

        val dataSource = RemoteDataSourceImpl(mockClient(engine))
        val response = dataSource.getPost(1)

        assertEquals(200, response.statusCode)
        assertEquals("Hello", response.body!!.title)
    }

    // createPost() — POST 생성
    @Test
    fun `createPost 성공`() = runBlocking {

        val engine = MockEngine { request ->
            when (request.url.toString()) {

                // POST 요청
                "https://jsonplaceholder.typicode.com/posts" -> respond(
                    content = postJson,
                    status = HttpStatusCode.Created, // 201
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )

                else -> respond(
                    content = """{"error":"invalid"}""",
                    status = HttpStatusCode.BadRequest,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            }
        }

        val dataSource = RemoteDataSourceImpl(mockClient(engine))
        val response = dataSource.createPost("dummy")

        assertEquals(201, response.statusCode)
        assertEquals("Hello", response.body!!.title)
    }

    // updatePost() — PUT
    @Test
    fun `updatePost 성공`() = runBlocking {

        val updatedJson = """{"id":1,"title":"Updated","body":"World","ussrId":1}"""

        val engine = MockEngine { request ->
            when (request.url.toString()) {

                "https://jsonplaceholder.typicode.com/posts/1" -> respond(
                    content = updatedJson,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )

                else -> respond(
                    content = """{"error":"not found"}""",
                    status = HttpStatusCode.NotFound
                )
            }
        }

        val dataSource = RemoteDataSourceImpl(mockClient(engine))
        val post = Post(id = 1, title = "Updated", body = "World", userId = 1)

        val response = dataSource.updatePost(1, post)

        assertEquals(200, response.statusCode)
        assertEquals("Updated", response.body!!.title)
    }

    // patchPost — PATCH
    @Test
    fun `patchPost 성공`() = runBlocking {

        val patchedJson = """{"id":1,"title":"Patched","body":"World","ussrId":1}"""

        val engine = MockEngine { request ->
            when (request.url.toString()) {

                "https://jsonplaceholder.typicode.com/posts/1" -> respond(
                    content = patchedJson,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )

                else -> respond(
                    content = """{"error":"not found"}""",
                    status = HttpStatusCode.NotFound
                )
            }
        }

        val dataSource = RemoteDataSourceImpl(mockClient(engine))
        val post = Post(id = 1, title = "Patched", body = "World", userId = 1)

        val response = dataSource.patchPost(1, post)

        assertEquals(200, response.statusCode)
        assertEquals("Patched", response.body!!.title)
    }

    // deletePost — DELETE
    @Test
    fun `deletePost 성공`() = runBlocking {

        val engine = MockEngine { request ->
            when (request.url.toString()) {

                "https://jsonplaceholder.typicode.com/posts/1" -> respond(
                    content = "",
                    status = HttpStatusCode.OK
                )

                else -> respond(
                    content = "",
                    status = HttpStatusCode.NotFound
                )
            }
        }

        val dataSource = RemoteDataSourceImpl(mockClient(engine))
        val response = dataSource.deletePost(1)

        assertEquals(200, response.statusCode)
    }

    // 존재하지 않는 ID — 404
    @Test
    fun `getPost 실패 - 존재하지 않는 ID`() = runBlocking {
        val engine = MockEngine { request ->
            respond(
                content = """{"error":"not found"}""",
                status = HttpStatusCode.NotFound,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        val dataSource = RemoteDataSourceImpl(mockClient(engine))
        val response = dataSource.getPost(984)

        assertEquals(404, response.statusCode)
    }

    @Test
    fun `getPosts - 네트워크 에러일 때 IOException 던짐`() = runTest {
        val errorEngine = MockEngine {
            throw IOException("No network connection")
        }
        val client = HttpClient(errorEngine)
        val dataSource = RemoteDataSourceImpl(client)

        val exception = runCatching {
            dataSource.getPosts()
        }.exceptionOrNull()

        assertTrue(exception is IOException)
        assertEquals("No network connection", exception?.message)
    }
}
