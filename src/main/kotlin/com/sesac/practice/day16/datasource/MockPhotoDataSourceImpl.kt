package com.sesac.practice.day16.datasource

import com.sesac.practice.day16.core.Response
import com.sesac.practice.day16.dto.PhotoDto

class MockPhotoDataSourceImpl : PhotoDataSource {

    override suspend fun getPhotos(): Response<List<PhotoDto>> {
        return Response(
            200,
            mapOf(),
            listOf(
                PhotoDto(
                    id = "1",
                    type = "article",
                    createdAt = "2020-01-01",
                    title = "This is an article",
                    content = "This is the content of the article.",
                ),
                PhotoDto(
                    id = "2",
                    type = "image",
                    createdAt = "2020-02-02",
                    url = "https://example.com/image.jpg",
                    caption = "This is an image.",
                ),
                PhotoDto(
                    id = "3",
                    type = "video",
                    createdAt = "2020-03-03",
                    title = null,
                    content = null,
                    url = "https://example.com/video.mp4",
                    caption = "This is a video.",
                ),
                PhotoDto(
                    id = "1",
                    type = "article",
                    createdAt = "2020-01-01",
                    title = "This is an article",
                    content = "This is the content of the article.",
                ),
                PhotoDto(
                    id = "2",
                    createdAt = "2020-02-02",
                    url = "https://example.com/image.jpg",
                    caption = "This is an image.",
                ),
                PhotoDto(
                    id = "3",
                    createdAt = "2020-03-03",
                    url = "https://example.com/video.mp4",
                    caption = "This is a video.",
                ),
            ),
        )
    }
}
