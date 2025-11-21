package com.hhp227.kotlinstudy.`15_http`

import com.hhp227.kotlinstudy.`15_http`.post.Post
import com.hhp227.kotlinstudy.`15_http`.post.PostRemoteDataSourceImpl
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class PostRemoteDataSourceImplTest {
    private lateinit var mockEngine: MockEngine

    private lateinit var client: HttpClient

    private lateinit var dataSource: PostRemoteDataSourceImpl

    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
    }

    private fun createClientWithMock(engine: MockEngine): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(json)
            }
        }
    }

    @Test
    fun `getPosts 메소드로 Post 리스트를 가져오는지 테스트`() = runTest {
        val mockResponse = listOf(Post(1, 1, "title", "body"))
        val bodyJson = json.encodeToString(mockResponse)

        mockEngine = MockEngine { request ->
            respond(
                content = bodyJson,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.getPosts()

        assertEquals(200, result.statusCode)
        assertEquals(mockResponse, result.data)
    }

    @Test
    fun `getPosts 메소드가 네트워크 에러가 나는지 테스트`() = runTest {
        mockEngine = MockEngine { error("Network Error") }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)

        assertFailsWith<Throwable> {
            dataSource.getPosts()
        }
    }

    @Test
    fun `getPosts 메소드가 404에러가 뜨는지 테스트`() = runTest {
        mockEngine = MockEngine { request ->
            respond(
                content = "[]",
                status = HttpStatusCode.NotFound,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.getPosts()

        assertEquals(404, result.statusCode)
        assertTrue(result.data.isEmpty())
    }

    @Test
    fun `getPost 메소드가 성공했는지 테스트`() = runTest {
        val mockPost = Post(1, 1, "test title", "test body")
        val bodyJson = json.encodeToString(mockPost)
        mockEngine = MockEngine {
            respond(bodyJson, HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.getPost(1)

        assertEquals(200, result.statusCode)
        assertEquals(mockPost, result.data)
    }

    @Test
    fun `getPost 메소드가 404 에러가 나는지 테스트`() = runTest {
        mockEngine = MockEngine {
            respond("{}", HttpStatusCode.NotFound, headersOf(HttpHeaders.ContentType, "application/json"))
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.getPost(999)

        assertEquals(404, result.statusCode)
    }

    @Test
    fun `getPost 매소드가 네트워크 에러가 나는지 테스트`() = runTest {
        mockEngine = MockEngine { error("Network failure") }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)

        assertFailsWith<Throwable> { dataSource.getPost(1) }
    }

    @Test
    fun `createPost 메소드로 요청하고 응답이 성공했는지 테스트`() = runTest {
        val newPost = Post(0, 1, "new", "post")
        val createdPost = newPost.copy(id = 101)
        val bodyJson = json.encodeToString(createdPost)
        mockEngine = MockEngine {
            respond(bodyJson, HttpStatusCode.Created, headersOf(HttpHeaders.ContentType, "application/json"))
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.createPost(newPost)

        assertEquals(201, result.statusCode)
        assertEquals(createdPost, result.data)
    }

    @Test
    fun `createPost 매소드가 네트워크 에러가 나는지 테스트`() = runTest {
        mockEngine = MockEngine { error("Network Error") }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)

        assertFailsWith<Throwable> { dataSource.createPost(Post(0, 1, "A", "B")) }
    }

    @Test
    fun `updatePost 메소드가 성공했는지 테스트`() = runTest {
        val updated = Post(1, 1, "update", "body")
        val jsonBody = json.encodeToString(updated)
        mockEngine = MockEngine {
            respond(jsonBody, HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.updatePost(1, updated)

        assertEquals(200, result.statusCode)
        assertEquals(updated, result.data)
    }

    @Test
    fun `updatePost 메소드가 404에러가 나는지 테스트`() = runTest {
        mockEngine = MockEngine {
            respond("{}", HttpStatusCode.NotFound, headersOf(HttpHeaders.ContentType, "application/json"))
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.updatePost(999, Post(999, 1, "A", "B"))

        assertEquals(404, result.statusCode)
    }

    @Test
    fun `patchPost 메소드가 성공했는지 테스트`() = runTest {
        val patched = Post(1, 1, "patched", "body")
        val jsonBody = json.encodeToString(patched)
        mockEngine = MockEngine {
            respond(jsonBody, HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.patchPost(1, patched)

        assertEquals(200, result.statusCode)
        assertEquals(patched, result.data)
    }

    @Test
    fun `deletePost 메소드가 성공했는지 테스트`() = runTest {
        mockEngine = MockEngine {
            respond("", HttpStatusCode.OK)
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.deletePost(1)

        assertEquals(200, result.statusCode)
        assertTrue(result.data)
    }

    @Test
    fun `deletePost 메소드가 404 에러가 뜨는지 테스트`() = runTest {
        mockEngine = MockEngine {
            respond("", HttpStatusCode.NotFound)
        }
        client = createClientWithMock(mockEngine)
        dataSource = PostRemoteDataSourceImpl(client)
        val result = dataSource.deletePost(999)

        assertEquals(404, result.statusCode)
        assertTrue(result.data)
    }
}
