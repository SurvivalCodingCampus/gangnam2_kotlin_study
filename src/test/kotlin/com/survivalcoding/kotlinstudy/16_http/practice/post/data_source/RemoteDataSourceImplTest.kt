package com.survivalcoding.kotlinstudy.`16_http`.practice.post.data_source

import com.survivalcoding.kotlinstudy.`16_http`.practice.data_source.RemoteDataSourceImpl
import com.survivalcoding.kotlinstudy.`16_http`.practice.model.Post
import com.survivalcoding.kotlinstudy.repository.core.Response
import io.ktor.client.*
import kotlinx.coroutines.runBlocking
import kotlinx.io.IOException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class RemoteDataSourceImplTest {

    private val client = HttpClient(PostMockEngine.mockEngine)
    private val api = RemoteDataSourceImpl(client)

    // 각 성공 케이스
    @Test
    fun `getPost()가 잘 동작하는지 확인`() = runBlocking {
        val result: Response<List<Post>> = api.getPost()
        val expectedCode = 200
        val expectedSize = 100
        val expectedFirstId = 1
        val expectedLastId = 100

        assertEquals(expectedCode, result.statusCode)
        assertEquals(expectedSize, result.body.size)
        assertEquals(expectedFirstId, result.body.first().id)
        assertEquals(expectedLastId, result.body.last().id)
    }

    @Test
    fun `getPost(id)가 잘 동작하는지 확인`() = runBlocking {
        val result: Response<Post> = api.getPost(1)

        val expectedCode = 200
        val expectedId = 1
        val expectedTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"

        assertEquals(expectedCode, result.statusCode)
        assertEquals(expectedId, result.body.id)
        assertEquals(expectedTitle, result.body.title)
    }

    @Test
    fun `createPost(post)가 잘 동작하는지 확인`() = runBlocking {
        val newPost = Post(
            userId = 1,
            id = 0,
            title = "new title",
            body = "new body"
        )
        val result = api.createPost(newPost)

        val expectedCode = 201
        val expectedId = 0
        val expectedTitle = "new title"

        assertEquals(expectedCode, result.statusCode)
        assertEquals(expectedId, result.body.id)
        assertEquals(expectedTitle, result.body.title)
    }

    @Test
    fun `updatePost(id, post)가 잘 동작하는지 확인`() = runBlocking {
        val updateId = 1
        val updatedPost = Post(
            userId = 1,
            id = updateId,
            title = "updated title",
            body = "updated body"
        )

        val result: Response<Post> = api.updatePost(updateId, updatedPost)

        val expectedCode = 200
        val expectedId = 1
        val expectedTitle = "updated title"

        assertEquals(expectedCode, result.statusCode)
        assertEquals(expectedId, result.body.id)
        assertEquals(expectedTitle, result.body.title)
    }

    @Test
    fun `patchPost(id, post)가 잘 동작하는지 확인`() = runBlocking {
        val patchId = 2
        val patchedPost = Post(
            userId = 1,
            id = patchId,
            title = "patched title",
            body = "patched body"
        )

        val result: Response<Post> = api.patchPost(patchId, patchedPost)

        val expectedCode = 200
        val expectedId = 2
        val expectedTitle = "patched title"

        assertEquals(expectedCode, result.statusCode)
        assertEquals(expectedId, result.body.id)
        assertEquals(expectedTitle, result.body.title)
    }

    @Test
    fun `deletePost(id)가 잘 동작하는지 확인`() = runBlocking {
        val result: Response<Unit> = api.deletePost(1)
        val expectedCode = 200

        assertEquals(expectedCode, result.statusCode)
    }

    // 네트워크 에러 케이스
    @Test
    fun `네트워크 에러가 발생하면 예외가 발생하는지 확인`(): Unit = runBlocking {
        val errorId = 1
        val errorClient = HttpClient(NetworkErrorMockEngine.engine)
        val errorApi = RemoteDataSourceImpl(errorClient)

        assertFailsWith<IOException> {
            errorApi.getPost(errorId)
        }
    }

    // 존재하지 않는 ID 요청 케이스
    @Test
    fun `존재하지 않는 ID를 요청하면 에러가 발생하는지 확인`(): Unit = runBlocking {
        val errorId = 1000
        val testPost = Post(
            userId = 1,
            id = errorId,
            title = "test title",
            body = "test body"
        )

        assertFailsWith<IllegalStateException> {
            api.getPost(errorId)
        }

        assertFailsWith<IllegalStateException> {
            api.updatePost(errorId, testPost)
        }

        assertFailsWith<IllegalStateException> {
            api.patchPost(errorId, testPost)
        }

        assertFailsWith<IllegalStateException> {
            api.deletePost(errorId)
        }
    }
}
