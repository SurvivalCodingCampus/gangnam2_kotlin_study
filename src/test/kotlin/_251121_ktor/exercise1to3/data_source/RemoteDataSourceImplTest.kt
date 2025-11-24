package _251121_ktor.exercise1to3.data_source

import _251121_ktor.exercise1to3.core.POSTSJSON
import _251121_ktor.exercise1to3.model.Post
import _251121_ktor.exercise1to3.model.Response
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals

class RemoteDataSourceImplTest {

    val mockClient = HttpClient(mockEngine) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }
    val remoteDataSourceImpl = RemoteDataSourceImpl(mockClient)

    @Test
    fun `getposts함수 사용시 posts를 모두 불러온다`() = runTest {
        val result = remoteDataSourceImpl.getPosts()
        val expected: List<Post> = Json.decodeFromString(POSTSJSON)
        assertEquals(expected, result.body)
    }

    @Test
    fun `getpost함수 인자가 100을 넘어가는 경우 404 NotFound가 뜬다`() = runTest {
        //when
        val result: Response<Post> = remoteDataSourceImpl.getPost(101)
        //then
        assertEquals(HttpStatusCode.NotFound.toString(), result.statusCode)
    }

    @Test
    fun `getpost함수 인자가 100을 넘어가지 않는 경우 OK가 뜬다`() = runTest {
        //when
        val result = remoteDataSourceImpl.getPost(100)
        //then
        assertEquals(HttpStatusCode.OK.toString(), result.statusCode)
    }

    @Test
    fun `createPost함수 사용시 새 게시글이 만들어진다`() = runTest {
        //given
        val newPost = Post(body = "testPost", title = "test", userId = 100, id = 101)
        //when
        val result = remoteDataSourceImpl.createPost(newPost)
        //then
        assertEquals(newPost, result.body)
        assertEquals(HttpStatusCode.OK.toString(), result.statusCode)
    }

    @Test
    fun `updatePost함수 사용시 게시글이 업데이트가 된다`() = runTest {
        //given
        val id = 1
        val newPost = Post(body = "after", title = "test", userId = 1, id = 1)
        //when
        val result = remoteDataSourceImpl.updatePost(id, newPost)
        //then
        assertEquals(newPost, result.body)
        assertEquals(HttpStatusCode.OK.toString(), result.statusCode)
    }

    @Test
    fun `patchPost함수 사용시 부분 업데이트가 된다`() = runTest {
        //given
        val id = 1
        val newPost = Post(body = "after", title = "test", userId = 1, id = 1)
        //when
        val result = remoteDataSourceImpl.patchPost(id, newPost)
        //then
        assertEquals(newPost, result.body)
        assertEquals(HttpStatusCode.OK.toString(), result.statusCode)
    }

    @Test
    fun `deletePost함수 사용시 게시글이 지워진다`() = runTest {
        //given
        val id = 1
        //when
        val result = remoteDataSourceImpl.deletePost(id)
        //then
        assertEquals(HttpStatusCode.OK, result)
    }

    @Test
    fun `deletePost함수에서 100보다 큰 id값의 게시글을 지울 시 404 Not Found가 뜬다`() = runTest {
        //given
        val id = 101
        //when
        val result = remoteDataSourceImpl.deletePost(id)
        //then
        assertEquals(HttpStatusCode.NotFound, result)
    }

    @Test
    fun `deletePost함수에서 5번 게시글을 지우려고 할 경우 네트워크 에러가 뜬다`() = runTest {
        //given
        val id = 5
        //when
        val result = remoteDataSourceImpl.deletePost(id)
        //then
        assertEquals(HttpStatusCode.InternalServerError, result)


    }

}