package com.ezlevup.my.day251125.exercise.data_source

import com.ezlevup.my.day251125.exercise.dto.PhotoDto
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class PhotoDataSourceImplTest {

    private lateinit var photoJsonText: String
    private lateinit var mockEngine: MockEngine
    private lateinit var mockPhotos: List<PhotoDto>

    @Before
    fun setUp() {
        photoJsonText = """
            [
              {
                "id": 1,
                "type": "article",
                "title": "This is an article",
                "content": "This is the content of the article.",
                "created_at": "2020-01-01"
              },
              {
                "id": 2,
                "type": "image",
                "url": "https://example.com/image.jpg",
                "caption": "This is an image.",
                "created_at": "2020-02-02"
              },
              {
                "id": 3,
                "type": "video",
                "url": "https://example.com/video.mp4",
                "caption": "This is a video.",
                "created_at": "2020-03-03"
              },
              {
    "id": "4",
    "type": "article",
    "title": "This is an article",
    "content": "This is the content of the article.",
    "created_at": "2020-01-01"
  },
  {
    "id": 5,
    "type": null,
    "url": "https://example.com/image.jpg",
    "caption": "This is an image.",
    "created_at": "2020-02-02"
  },
  {
    "id": 6,

    "url": "https://example.com/video.mp4",
    "caption": "This is a video.",
    "created_at": "2020-03-03"
  }
            ]
        """.trimIndent()
        mockPhotos = Json.decodeFromString<List<PhotoDto>>(photoJsonText)
        mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel(photoJsonText),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
    }

    @After
    fun tearDown() {

    }

    @Test
    fun getPhotos(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(mockEngine)
        val dataSource = PhotoDataSourceImpl(client)

        // when
        val result = dataSource.getPhotos()

        // then
        assertEquals(HttpStatusCode.OK, result.status)
        assertEquals(mockPhotos.count(), result.body?.count())
        println(result.body?.count())
        result.body?.map(::println)
    }


    @Test(expected = SerializationException::class)
    fun `PhotoDto 타입 불일치`() {
        // given
        val invalidJson = """
    [
      {
        "id": "not_a_number",
        "type": "article"
      }
    ]
    """.trimIndent()

        // when & then
        Json.decodeFromString<List<PhotoDto>>(invalidJson)
    }


    @Test
    fun `PhotoDto id 가 null 경우`() {
        val jsonWithoutId = """
    [
      {
        "type": "article",
        "title": "Test"
      }
    ]
    """.trimIndent()

        val result = Json.decodeFromString<List<PhotoDto>>(jsonWithoutId)
        assertNull(result[0].id)
    }


}