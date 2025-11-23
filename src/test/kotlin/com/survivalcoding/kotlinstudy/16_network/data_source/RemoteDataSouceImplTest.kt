package com.survivalcoding.kotlinstudy.`16_network`.data_source

import com.survivalcoding.kotlinstudy.`16_network`.mock.RemoteDataSourceMockEngine
import com.survivalcoding.kotlinstudy.`16_network`.mock.TestHttpClientFactory
import com.survivalcoding.kotlinstudy.`16_network`.model.Post
import io.ktor.client.*
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class RemoteDataSourceImplTest {

    companion object {

        // Status Codes
        private const val STATUS_OK = 200
        private const val STATUS_CREATED = 201
        private const val STATUS_NOT_FOUND = 404
        private const val STATUS_SERVER_ERROR = 500

        // IDs
        private const val USER_ID = 1
        private const val VALID_ID = 1
        private const val INVALID_ID = 9999
        private const val NEW_POST_ID = 0

        // Titles
        private const val TITLE_HELLO = "Hello"
        private const val TITLE_NEW = "New"
        private const val TITLE_UPDATED = "Updated"
        private const val TITLE_PATCHED = "Patched"

        // Title 랜덤
        private const val TITLE_X = "x"
        private const val TITLE_Z = "z"

        // Body
        private const val BODY_SAMPLE = "Body"
        private const val BODY_SIZE = 2
        private const val BODY_Y = "y"
        private const val BODY_Z = "z"
    }

    // GET /posts 성공
    @Test
    fun `getPosts 성공`() = runBlocking {
        val client = HttpClient(RemoteDataSourceMockEngine.getPostsSuccess())
        val dataSource = RemoteDataSouceImpl(client)

        val response = dataSource.getPosts()

        assertEquals(STATUS_OK, response.statusCode)
        assertNotNull(response.body)
        assertEquals(BODY_SIZE, response.body.size)
        assertEquals(TITLE_HELLO, response.body[0].title)
    }

    // GET /post/{id} 성공
    @Test
    fun `getPost 성공`() = runBlocking {
        val client = HttpClient(RemoteDataSourceMockEngine.getPostSuccess())
        val dataSource = RemoteDataSouceImpl(client)

        val response = dataSource.getPost(VALID_ID)

        assertEquals(STATUS_OK, response.statusCode)
        assertEquals(TITLE_HELLO, response.body!!.title)
    }

    // GET /post/{id} - 404 Not Found
    @Test
    fun `getPost 실패 - 404 Not Found`() = runBlocking {
        val client = HttpClient(RemoteDataSourceMockEngine.getPostNotFound())
        val dataSource = RemoteDataSouceImpl(client)

        val response = dataSource.getPost(INVALID_ID)

        assertEquals(STATUS_NOT_FOUND, response.statusCode)
        assertNull(response.body)
    }

    // Get /posts - 서버 에러 500
    @Test
    fun `getPosts - 500 서버 에러`() = runBlocking {
        val client = HttpClient(RemoteDataSourceMockEngine.serverError())
        val dataSource = RemoteDataSouceImpl(client)

        val response = dataSource.getPosts()

        assertEquals(STATUS_SERVER_ERROR, response.statusCode)
        assertNull(response.body)
    }

    // POST 성공
    @Test
    fun `createPost 성공`() = runBlocking {
        val client = TestHttpClientFactory.create(RemoteDataSourceMockEngine.createPostSuccess())
        val dataSource = RemoteDataSouceImpl(client)

        val newPost = Post(
            userId = USER_ID,
            id = NEW_POST_ID,
            title = TITLE_NEW,
            body = BODY_SAMPLE
        )

        val response = dataSource.createPost(newPost)

        assertEquals(STATUS_CREATED, response.statusCode)
        assertEquals(TITLE_NEW, TITLE_NEW) // 유지 보수 목적 상수 체크
        assertEquals(TITLE_NEW, TITLE_NEW)
    }

    // PUT 성공
    @Test
    fun `updatePost 성공`() = runBlocking {
        val client = TestHttpClientFactory.create(RemoteDataSourceMockEngine.updatePostSuccess())

        val dataSource = RemoteDataSouceImpl(client)

        val updatePost = Post(USER_ID, VALID_ID, TITLE_X, BODY_Y)

        val response = dataSource.updatePost(VALID_ID, updatePost)

        assertEquals(STATUS_OK, response.statusCode)
        assertEquals(TITLE_UPDATED, response.body!!.title)
    }

    // PATCH 성공
    @Test
    fun `patchPost 성공`() = runBlocking {
        val client = TestHttpClientFactory.create(RemoteDataSourceMockEngine.patchPostSuccess())

        val dataSource = RemoteDataSouceImpl(client)

        val patchPost = Post(USER_ID, VALID_ID, TITLE_Z, BODY_Z)

        val response = dataSource.patchPost(VALID_ID, patchPost)

        assertEquals(STATUS_OK, response.statusCode)
        assertEquals(TITLE_PATCHED, response.body!!.title)
    }

    // DELETE 성공
    @Test
    fun `deletePost 성공`() = runBlocking {
        val client = HttpClient(RemoteDataSourceMockEngine.deletePostSuccess())
        val dataSource = RemoteDataSouceImpl(client)

        val response = dataSource.deletePost(VALID_ID)

        assertEquals(STATUS_OK, response.statusCode)
        assertNull(response.body)
    }
}
