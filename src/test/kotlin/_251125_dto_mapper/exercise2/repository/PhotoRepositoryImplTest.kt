package _251125_dto_mapper.exercise2.repository

import _251125_dto_mapper.exercise2.data_source.PhotoDataSourceImpl
import _251125_dto_mapper.exercise2.model.PhotoType
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PhotoRepositoryImplTest {
    lateinit var mockEngine: MockEngine
    lateinit var mockClient: HttpClient
    lateinit var photoDataSourceImpl: PhotoDataSourceImpl
    lateinit var photoRepositoryImpl: PhotoRepositoryImpl

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
  },
  {
    "id": 4,
    "type": "",
    "url": "https://example.com/video.mp4",
    "caption": "This is a video.",
    "created_at": "2020-04-04"
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
        photoRepositoryImpl = PhotoRepositoryImpl(photoDataSourceImpl)

    }

    @Test
    fun `getAllPhotos() -  createAt의 type이 LocalDate형이다`() = runTest {
        val result = photoRepositoryImpl.getAllPhotos()
        assertTrue(result[0].createdAt is LocalDate)
    }

    @Test
    fun `type이 없는 경우 UNKNOWN으로 된다`() = runTest {
        val response = photoRepositoryImpl.getAllPhotos()
        assertEquals(PhotoType.UNKNOWN, response[3].type)

    }
}