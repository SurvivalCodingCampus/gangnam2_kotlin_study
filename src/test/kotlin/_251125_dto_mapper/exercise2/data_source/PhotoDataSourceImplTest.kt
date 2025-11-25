package _251125_dto_mapper.exercise2.data_source

import _251125_dto_mapper.exercise2.dto.PhotoDto
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class PhotoDataSourceImplTest {
    lateinit var mockEngine: MockEngine
    lateinit var mockClient: HttpClient
    lateinit var photoDataSourceImpl: PhotoDataSourceImpl

    @Before
    fun `모의 서버 구축`() {
        mockEngine = MockEngine { request ->
            when (request.url.toString()) {
                "http://localhost/test1" -> {
                    respond(
                        status = HttpStatusCode.OK,
                        content = """[
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
  }
]


"""
                    )
                }

                else -> {
                    respond(
                        status = HttpStatusCode.NotFound,
                        content = "[ ]"
                    )
                }
            }
        }
        mockClient = HttpClient(mockEngine)
        photoDataSourceImpl = PhotoDataSourceImpl(mockClient)
    }


    @Test
    fun `getAllPhoto() - 모의서버로부터 데이터가 잘 불러와진다`() = runTest {
        val response = photoDataSourceImpl.getAllPhoto()
        assertEquals(
            Json.decodeFromString<List<PhotoDto>>(
                """[
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
  }
]
"""
            ), response.body
        )
        assertEquals(HttpStatusCode.OK.toString(), response.statusCode)
    }


}