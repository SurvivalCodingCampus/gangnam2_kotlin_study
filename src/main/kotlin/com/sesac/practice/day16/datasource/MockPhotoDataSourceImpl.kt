package com.sesac.practice.day16.datasource

import com.sesac.practice.day16.core.Response
import com.sesac.practice.day16.dto.PhotoDto
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl : PhotoDataSource {

    private val testJson = """
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
            "id": "1",
            "type": "article",
            "title": "This is an article",
            "content": "This is the content of the article.",
            "created_at": "2020-01-01"
          },
          {
            "id": 2,
            "type": null,
            "url": "https://example.com/image.jpg",
            "caption": "This is an image.",
            "created_at": "2020-02-02"
          },
          {
            "id": 3,
            "url": "https://example.com/video.mp4",
            "caption": "This is a video.",
            "created_at": "2020-03-03"
          }
        ]
    """.trimIndent()

    private val json = Json {
        isLenient = true
    }

    override suspend fun getPhotos(): Response<List<PhotoDto>> {
        val photoDtos = json.decodeFromString<List<PhotoDto>>(testJson)

        return Response(
            200,
            mapOf(),
            photoDtos,
        )
    }
}
