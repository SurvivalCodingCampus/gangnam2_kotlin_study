package com.survival.kotlinstudy.day16.datasource

import com.survival.kotlinstudy.day16.model.Post
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals

class RemoteDataSourceImplTest {
    private val dummyPost = Post(userId = 1, id = 1, title = "Test Title", body = "Test Body")
    private val dummyPostList = listOf(dummyPost, dummyPost.copy(id = 2))

    @Test
    fun `getPosts() 성공 테스트`() = runBlocking {

        val mockEngine = MockEngine { request ->
            respond(
                content = Json.encodeToString(dummyPostList),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)



        val postsResponse = datasource.getPosts()


        assertEquals(postsResponse.codeStatus, HttpStatusCode.OK.value)
        assertEquals("application/json",postsResponse.header[HttpHeaders.ContentType])
        assertEquals(2,postsResponse.body?.size)

    }

    @Test
    fun `getPosts() 네트워크 에러 테스트`() = runBlocking {
        val mockEngine = MockEngine { request ->
            respond(
                content = Json.encodeToString(dummyPostList),
                status = HttpStatusCode.NotFound,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)



        val postsResponse = datasource.getPosts()


        assertEquals(postsResponse.codeStatus, HttpStatusCode.NotFound.value)
        assertEquals("application/json",postsResponse.header[HttpHeaders.ContentType])
        assertEquals(2,postsResponse.body?.size)

    }


    @Test
    fun `getPost() 테스트 - 정상`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val postResponse = datasource.getPost(1)

        assertEquals(postResponse.codeStatus, HttpStatusCode.OK.value)
        assertEquals("application/json",postResponse.header[HttpHeaders.ContentType])
        assertEquals(postResponse.body?.id,1)
        assertEquals(postResponse.body?.userId,1)
        assertEquals(postResponse.body?.title,"title1")
        assertEquals(postResponse.body?.body,"body1")
    }

    @Test
    fun `getPost() 테스트 - 에러`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.InternalServerError,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val postResponse = datasource.getPost(1)

        assertEquals(postResponse.codeStatus, HttpStatusCode.InternalServerError.value)
        assertEquals("application/json",postResponse.header[HttpHeaders.ContentType])

    }

    @Test
    fun `getPost() 테스트 - 존재하지 않는 ID`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.NotFound,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val postResponse = datasource.getPost(9999)

        assertEquals(postResponse.codeStatus, HttpStatusCode.NotFound.value)
        assertEquals("application/json",postResponse.header[HttpHeaders.ContentType])


    }


    @Test
    fun `createPost() 테스트 - 정상`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val createResponse = datasource.createPost(dummyPost)

        assertEquals(createResponse.codeStatus, HttpStatusCode.OK.value)
        assertEquals("application/json",createResponse.header[HttpHeaders.ContentType])
        assertEquals(createResponse.body?.id,1)
        assertEquals(createResponse.body?.userId,1)
        assertEquals(createResponse.body?.title,"title1")
        assertEquals(createResponse.body?.body,"body1")
    }

    @Test
    fun `createPost() 테스트 - 에러`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.InternalServerError,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val createResponse = datasource.createPost(dummyPost)

        assertEquals(createResponse.codeStatus, HttpStatusCode.InternalServerError.value)
        assertEquals("application/json",createResponse.header[HttpHeaders.ContentType])

    }


    @Test
    fun `updatePost() 테스트 - 정상`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val updateResponse = datasource.updatePost(1,dummyPost)

        assertEquals(updateResponse.codeStatus, HttpStatusCode.OK.value)
        assertEquals("application/json",updateResponse.header[HttpHeaders.ContentType])
        assertEquals(updateResponse.body?.id,1)
        assertEquals(updateResponse.body?.userId,1)
        assertEquals(updateResponse.body?.title,"title1")
        assertEquals(updateResponse.body?.body,"body1")
    }

    @Test
    fun `updatePost() 테스트 - 에러`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.InternalServerError,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val updateResponse = datasource.updatePost(1,dummyPost)

        assertEquals(updateResponse.codeStatus, HttpStatusCode.InternalServerError.value)
        assertEquals("application/json",updateResponse.header[HttpHeaders.ContentType])

    }

    @Test
    fun `updatePost() 테스트 - 존재하지 않는 ID`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.NotFound,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val updateResponse = datasource.updatePost(9999,dummyPost)

        assertEquals(updateResponse.codeStatus, HttpStatusCode.NotFound.value)
        assertEquals("application/json",updateResponse.header[HttpHeaders.ContentType])


    }

    @Test
    fun `patchPost() 테스트 - 정상`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val patchResponse = datasource.patchPost(1,dummyPost)

        assertEquals(patchResponse.codeStatus, HttpStatusCode.OK.value)
        assertEquals("application/json",patchResponse.header[HttpHeaders.ContentType])
        assertEquals(patchResponse.body?.id,1)
        assertEquals(patchResponse.body?.userId,1)
        assertEquals(patchResponse.body?.title,"title1")
        assertEquals(patchResponse.body?.body,"body1")
    }

    @Test
    fun `patchPost() 테스트 - 에러`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.InternalServerError,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val patchResponse = datasource.patchPost(1,dummyPost)

        assertEquals(patchResponse.codeStatus, HttpStatusCode.InternalServerError.value)
        assertEquals("application/json",patchResponse.header[HttpHeaders.ContentType])

    }

    @Test
    fun `patchPost() 테스트 - 존재하지 않는 ID`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.NotFound,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val patchResponse = datasource.patchPost(9999,dummyPost)

        assertEquals(patchResponse.codeStatus, HttpStatusCode.NotFound.value)
        assertEquals("application/json",patchResponse.header[HttpHeaders.ContentType])


    }

    @Test
    fun `deletePost() 테스트 - 정상`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val deleteResponse = datasource.deletePost(1)

        assertEquals(deleteResponse.codeStatus, HttpStatusCode.OK.value)
        assertEquals("application/json",deleteResponse.header[HttpHeaders.ContentType])
    }

    @Test
    fun `deletePost() 테스트 - 에러`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.InternalServerError,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val deleteResponse = datasource.deletePost(1)

        assertEquals(deleteResponse.codeStatus, HttpStatusCode.InternalServerError.value)
        assertEquals("application/json",deleteResponse.header[HttpHeaders.ContentType])

    }

    @Test
    fun `deletePost() 테스트 - 존재하지 않는 ID`() = runBlocking {
        val mockEngine = MockEngine {request ->
            respond(
                content = """
                    {
                      "userId": 1,
                      "id": 1,
                      "title": "title1",
                      "body": "body1"
                    }
                """,
                status = HttpStatusCode.NotFound,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val datasource = RemoteDataSourceImpl(client)

        val deleteResponse = datasource.deletePost(9999)

        assertEquals(deleteResponse.codeStatus, HttpStatusCode.NotFound.value)
        assertEquals("application/json",deleteResponse.header[HttpHeaders.ContentType])


    }




}