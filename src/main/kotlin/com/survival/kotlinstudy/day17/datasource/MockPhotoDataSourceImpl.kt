package com.survival.kotlinstudy.day17.datasource

import com.survival.kotlinstudy.day17.dto.PhotoDto
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl : PhotoDataSource {
    private val photos = """
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

    override suspend fun getPhotos(): List<PhotoDto> {
        return Json.decodeFromString(photos)
    }
}


fun main() = runBlocking {
    val datasource = MockPhotoDataSourceImpl()

    println(datasource.getPhotos().joinToString("\n"))
}