package com.survivaalcoding.kotlinstudy.`15_network`.example.repository

import com.survivaalcoding.kotlinstudy.`15_network`.example.datasource.RemoteDataSourceImpl
import com.survivaalcoding.kotlinstudy.`15_network`.example.model.Post
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertNull

private val id1 = 1L
private val id2 = 2L
private val title1 = "Test Title1"
private val title2 = "Test Title2"
private val title3 = "Title3"
private val body1 = "Test Body1"
private val body2 = "Test Body2"

private val mockPost1 = Post(userId = id1, id = id1, title = title1, body = body1)
private val mockPost2 = Post(userId = id1, id = id2, title = title2, body = body2)
private val mockPost3 = Post(userId = id2, id = id2, title = title3, body = body2)
private val mockList1 = listOf(mockPost1, mockPost2)
private val mockList2 = listOf(mockPost1, mockPost2, mockPost3)
private val json = Json { ignoreUnknownKeys = true }

class PostRepositoryImplTest {
    @Test
    fun `전체 조회 시 리스트 데이터를 받는다`() = runTest {
        // given
        val mockEngine = MockEngine { _ ->
            respond(
                content = json.encodeToString(mockList1),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)
        val repository: PostRepository = PostRepositoryImpl(dataSource)

        // when
        val actual = repository.getPosts()

        // then
        assertEquals(2, actual.size)
        assertEquals(mockList1, actual)
    }

    @Test
    fun `단일 조회 시 ID에 해당하는 데이터를 받는다`() = runTest {
        // given
        val mockEngine = MockEngine { _ ->
            respond(
                content = json.encodeToString(mockPost1),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)
        val repository: PostRepository = PostRepositoryImpl(dataSource)

        // when
        val actual = repository.getPost(id1)

        // then
        assertNotNull(actual)
        assertEquals(mockPost1, actual)
    }

    @Test
    fun `존재하지 않는 ID 요청 시 NULL을 반환한다`() = runTest {
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
        val repository: PostRepository = PostRepositoryImpl(dataSource)

        // when
        val actual = repository.getPost(Long.MAX_VALUE)

        // then
        assertNull(actual)
    }

    @Test
    fun `저장 시 생성된 데이터를 받는다`() = runTest {
        // given
        val mockEngine = MockEngine { _ ->
            respond(
                content = json.encodeToString(mockPost1),
                status = HttpStatusCode.Created,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)
        val repository: PostRepository = PostRepositoryImpl(dataSource)

        // when
        val actual = repository.createPost(mockPost1)

        // then
        assertEquals(mockPost1, actual)
    }

    @Test
    fun `전체 수정 시 수정된 데이터를 받는다`() = runTest {
        // given
        val expectedId = 1L
        val updatedPost = Post(
            id = expectedId,
            title = "update foo",
            body = "update bar",
            userId = 1L
        )

        val mockEngine = MockEngine { _ ->
            respond(
                content = json.encodeToString(updatedPost),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)
        val repository: PostRepository = PostRepositoryImpl(dataSource)

        // when
        val actual = repository.updatePost(expectedId, updatedPost)

        // then
        assertEquals(updatedPost, actual)
    }

    @Test
    fun `일부 수정 시 변경된 데이터 포함해 받는다`() = runTest {
        // given
        val updatedPost = Post(
            id = id1,
            title = "update foo",
            body = body1,
            userId = id1
        )

        val mockEngine = MockEngine { _ ->
            respond(
                content = json.encodeToString(updatedPost),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)
        val repository: PostRepository = PostRepositoryImpl(dataSource)

        // when
        val actual = repository.patchPost(id1, updatedPost)

        // then
        assertEquals(updatedPost, actual)
    }

    @Test
    fun `Post 삭제 시 200 상태 코드를 받는다`() = runTest {
        // given
        val mockEngine = MockEngine { _ ->
            respond(
                content = "{}",
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)
        val repository: PostRepository = PostRepositoryImpl(dataSource)

        // when
        val actual = repository.deletePost(id1)

        // then
        assertIs<Unit>(actual)
    }

    @Test
    fun `title에 특정 키워드가 포함된 게시글 리스트를 조회할 수 있다`() = runTest {
        // given
        val keyword = "Test"

        val mockEngine = MockEngine { _ ->
            respond(
                content = json.encodeToString(mockList2),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val apiClient = HttpClient(mockEngine)
        val dataSource = RemoteDataSourceImpl(apiClient)
        val repository: PostRepository = PostRepositoryImpl(dataSource)

        // when
        val actual = repository.getPostsByKeyword(keyword)

        // then
        assertEquals(2, actual.size)
        assertEquals(mockList1, actual)
    }
}