package com.ezlevup.my.day251125.exercise.repository

import com.ezlevup.my.day251125.exercise.data_source.MockPhotoDataSourceImpl
import com.ezlevup.my.day251125.exercise.dto.PhotoDto
import io.ktor.client.engine.mock.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class PhotoRepositoryImplTest {

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
    }

    @After
    fun tearDown() {

    }

    @Test
    fun getPhotos(): Unit = runBlocking {
        // given
        val photoRepository = PhotoRepositoryImpl(MockPhotoDataSourceImpl(mockPhotos))

        // when
        val result = photoRepository.getPhotos()

        // then
        assertEquals(mockPhotos.count(), result.count())
        result.map(::println)
    }

}