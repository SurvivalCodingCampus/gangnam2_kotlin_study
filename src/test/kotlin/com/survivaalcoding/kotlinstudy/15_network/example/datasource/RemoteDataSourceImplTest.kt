package com.survivaalcoding.kotlinstudy.`15_network`.example.datasource

import com.survivaalcoding.kotlinstudy.`15_network`.example.model.Post
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlinx.io.IOException
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

private val id = 1L
private val title = "Test Title"
private val body = "Test Body"

private val mockPost = Post(userId = id, id = id, title = title, body = body)
private val mockList = listOf(mockPost)
private val json = Json { ignoreUnknownKeys = true }

class RemoteDataSourceImplTest {
    @Test
    fun `Post 전체 조회 시 200 상태 코드와 데이터를 받는다`() = runTest {
        // given
        val mockEngine = MockEngine { request ->
            respond(
                content = json.encodeToString(mockList),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)

        // when
        val response = dataSource.getPosts()

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
        assertEquals(1, response.body.size)
        assertEquals(id, response.body[0].id)
        assertEquals(title, response.body[0].title)
        assertEquals(body, response.body[0].body)
    }

    @Test
    fun `Post 단일 조회 시 200 상태 코드와 ID에 해당하는 데이터를 받는다`() = runTest {
        // given
        val expectedId = 1L

        val mockEngine = MockEngine { request ->
            respond(
                content = json.encodeToString(mockPost),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)

        // when
        val response = dataSource.getPost(expectedId)

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
        assertEquals(expectedId, response.body?.id)
        assertEquals(title, response.body?.title)
        assertEquals(body, response.body?.body)
    }

    @Test
    fun `존재하지 않는 ID 요청 시(404) 상태코드를 반환한다`() = runTest {
        // given
        val mockEngine = MockEngine { _ ->
            respond(
                content = "{}",
                status = HttpStatusCode.NotFound,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)

        // when
        val response = dataSource.getPost(Long.MAX_VALUE)

        // then
        assertEquals(HttpStatusCode.NotFound.value, response.statusCode)
    }

    @Test
    fun `Post 저장 시 201 상태 코드와 데이터를 받는다`() = runTest {
        // given
        val mockEngine = MockEngine { request ->
            respond(
                content = json.encodeToString(mockPost),
                status = HttpStatusCode.Created,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)

        // when
        val response = dataSource.createPost(mockPost)

        // then
        assertEquals(HttpStatusCode.Created.value, response.statusCode)
    }

    @Test
    fun `Post PUT 수정 시 200 상태 코드와 데이터를 받는다`() = runTest {
        // given
        val expectedId = 1L
        val updatedPost = Post(
            id = expectedId,
            title = "update foo",
            body = "update bar",
            userId = 1L
        )

        val mockEngine = MockEngine { request ->
            respond(
                content = json.encodeToString(updatedPost),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)

        // when
        val response = dataSource.updatePost(expectedId, mockPost)

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
        assertEquals(expectedId, response.body.id)
        assertEquals(updatedPost.title, response.body.title)
        assertEquals(updatedPost.body, response.body.body)
        assertEquals(updatedPost.userId, response.body.userId)
    }

    @Test
    fun `Post PATCH 수정 시 200 상태 코드와 데이터를 받는다`() = runTest {
        // given
        val expectedId = 1L
        val updatedPost = Post(
            id = expectedId,
            title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            body = "update body",
            userId = 1L
        )

        val mockEngine = MockEngine { request ->
            respond(
                content = json.encodeToString(updatedPost),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)

        // when
        val response = dataSource.patchPost(expectedId, mockPost)

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
        assertEquals(expectedId, response.body.id)
        assertEquals(updatedPost.title, response.body.title)
        assertEquals(updatedPost.body, response.body.body)
        assertEquals(updatedPost.userId, response.body.userId)
    }

    @Test
    fun `Post 삭제 시 200 상태 코드를 받는다`() = runTest {
        // given
        val mockEngine = MockEngine { request ->
            respond(
                content = "{}",
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)

        // when
        val response = dataSource.deletePost(id)

        // then
        assertEquals(HttpStatusCode.OK.value, response.statusCode)
    }

    @Test
    fun `네트워크 에러 발생 시 예외가 던져진다`() = runTest {
        // given
        val mockEngine = MockEngine { _ ->
            throw IOException()
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)

        // when
        // then
        assertFailsWith<IOException> {
            dataSource.getPosts()
        }
    }
}