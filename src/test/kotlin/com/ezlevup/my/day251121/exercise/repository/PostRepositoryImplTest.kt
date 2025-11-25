package com.ezlevup.my.day251121.exercise.repository

import com.ezlevup.my.day251121.exercise.data_source.RemoteDataSourceImpl
import com.ezlevup.my.day251121.exercise.model.Post
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class PostRepositoryImplTest {

    private lateinit var mockEngine: MockEngine
    private lateinit var mockEngineId8: MockEngine
    private lateinit var mockPosts: List<Post>
    private lateinit var mockPostId8: Post
    private lateinit var postJsonText: String
    private lateinit var postJsonText8: String

    @Before
    fun setUp() {

        postJsonText = """
                    [
  {
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat iamlee occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
  },
  {
    "userId": 1,
    "id": 2,
    "title": "qui est esse",
    "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
  },
  {
    "userId": 1,
    "id": 3,
    "title": "ea molestias quasi exercitationem repellat qui ipsa sit aut",
    "body": "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
  },
  {
    "userId": 1,
    "id": 4,
    "title": "eum et est occaecati",
    "body": "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit"
  },
  {
    "userId": 1,
    "id": 5,
    "title": "nesciunt quas odio",
    "body": "repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque"
  },
  {
    "userId": 1,
    "id": 6,
    "title": "dolorem eum magni eos aperiam quia",
    "body": "ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae"
  },
  {
    "userId": 1,
    "id": 7,
    "title": "magnam facilis autem",
    "body": "dolore placeat quibusdam ea quo vitae\nmagni quis enim qui quis quo nemo aut saepe\nquidem repellat excepturi ut quia\nsunt ut sequi eos ea sed quas"
  },
  {
    "userId": 1,
    "id": 8,
    "title": "dolorem dolore est ipsam",
    "body": "dignissimos aperiam dolorem qui eum\nfacilis quibusdam animi sint suscipit qui sint possimus cum\nquaerat magni maiores excepturi\nipsam ut commodi dolor voluptatum modi aut vitae"
  },
  {
    "userId": 1,
    "id": 9,
    "title": "nesciunt iure omnis dolorem tempora et accusantium",
    "body": "consectetur animi nesciunt iure dolore\nenim quia ad\nveniam autem ut quam aut nobis\net est aut quod aut provident voluptas autem voluptas"
  },
  {
    "userId": 1,
    "id": 10,
    "title": "optio molestias id quia eum",
    "body": "quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error"
  },
  {
    "userId": 2,
    "id": 11,
    "title": "et ea vero quia laudantium autem",
    "body": "delectus reiciendis molestiae occaecati non minima eveniet qui voluptatibus\naccusamus in eum beatae sit\nvel qui neque voluptates ut commodi qui incidunt\nut animi commodi"
  }
  ]
                    """.trimIndent()

        postJsonText8 = """
            {
              "userId": 1,
              "id": 8,
              "title": "dolorem dolore est ipsam",
              "body": "dignissimos aperiam dolorem qui eum\nfacilis quibusdam animi sint suscipit qui sint possimus cum\nquaerat magni maiores excepturi\nipsam ut commodi dolor voluptatum modi aut vitae"
            }
        """.trimIndent()

        mockPosts = Json.decodeFromString<List<Post>>(postJsonText)
        mockPostId8 = Json.decodeFromString<Post>(postJsonText8)

        mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel(postJsonText),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        mockEngineId8 = MockEngine { request ->
            respond(
                content = ByteReadChannel(postJsonText8),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
    }

    @Test
    fun getPosts(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(mockEngine)
        val postRepository = PostRepositoryImpl(RemoteDataSourceImpl(client))

        // when
        val result = postRepository.getPosts()

        // then
        assertEquals(HttpStatusCode.OK, result.status)
        assertEquals(mockPosts.count(), result.body!!.count())
    }

    @Test
    fun `getPosts(id)`(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(mockEngineId8)
        val postRepository = PostRepositoryImpl(RemoteDataSourceImpl(client))

        // when
        val result = postRepository.getPost(mockPostId8.id)

        // then
        assertEquals(HttpStatusCode.OK, result.status)
        assertEquals(mockPostId8.id, result.body!!.id)
    }

    @Test
    fun createPost(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(mockEngineId8)
        val postRepository = PostRepositoryImpl(RemoteDataSourceImpl(client))

        // when
        val result = postRepository.createPost(mockPostId8)

        // then
        assertEquals(HttpStatusCode.OK, result.status)
        assertEquals(mockPostId8.id, result.body!!.id)
    }

    @Test
    fun updatePost(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(mockEngineId8)
        val postRepository = PostRepositoryImpl(RemoteDataSourceImpl(client))

        // when
        val result = postRepository.updatePost(mockPostId8.id, mockPostId8)

        // then
        assertEquals(HttpStatusCode.OK, result.status)
        assertEquals(mockPostId8.id, result.body!!.id)
    }

    @Test
    fun patchPost(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(mockEngineId8)
        val postRepository = PostRepositoryImpl(RemoteDataSourceImpl(client))

        // when
        val result = postRepository.patchPost(mockPostId8.id, mockPostId8)

        // then
        assertEquals(HttpStatusCode.OK, result.status)
        assertEquals(mockPostId8.id, result.body!!.id)
    }

    @Test
    fun deletePost(): Unit = runBlocking {
        // given
        val postRepository = PostRepositoryImpl(RemoteDataSourceImpl())

        // when
        val result = postRepository.deletePost(mockPostId8.id)

        // then
        assertTrue(result)
    }

    @Test
    fun getPostsByKeyword(): Unit = runBlocking {
        // given
        val postRepository = PostRepositoryImpl(RemoteDataSourceImpl())

        // when
        val keyword: String = "dolore"
        val result = postRepository.getPostsByKeyword(keyword)

        // then
        assertNotNull(result)
    }

    @Test
    fun getPostsByKeywordFromMock(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(mockEngine)
        val postRepository = PostRepositoryImpl(RemoteDataSourceImpl(client))

        // when
        val keyword: String = "iamlee"
        val result = postRepository.getPostsByKeyword(keyword)

        // then
        assertEquals(1, result.count())
    }


}