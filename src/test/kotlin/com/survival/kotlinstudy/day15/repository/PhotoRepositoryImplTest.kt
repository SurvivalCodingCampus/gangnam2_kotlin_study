package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockPhotoDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class PhotoRepositoryImplTest {

    @Test
    fun `PhotoRepositoryImpl getPhotos() 테스트`(): Unit = runBlocking {
        val text = """
            [
              {
                "albumId": 1,
                "id": 1,
                "title": "accusamus beatae ad facilis cum similique qui sunt",
                "url": "https://via.placeholder.com/600/92c952",
                "thumbnailUrl": "https://via.placeholder.com/150/92c952"
              },
              {
                "albumId": 1,
                "id": 2,
                "title": "reprehenderit est deserunt velit ipsam",
                "url": "https://via.placeholder.com/600/771796",
                "thumbnailUrl": "https://via.placeholder.com/150/771796"
              },
              {
                "albumId": 1,
                "id": 3,
                "title": "officia porro iure quia iusto qui ipsa ut modi",
                "url": "https://via.placeholder.com/600/24f355",
                "thumbnailUrl": "https://via.placeholder.com/150/24f355"
              },
              {
                "albumId": 1,
                "id": 4,
                "title": "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
                "url": "https://via.placeholder.com/600/d32776",
                "thumbnailUrl": "https://via.placeholder.com/150/d32776"
              },
              {
                "albumId": 1,
                "id": 5,
                "title": "natus nisi omnis corporis facere molestiae rerum in",
                "url": "https://via.placeholder.com/600/f66b97",
                "thumbnailUrl": "https://via.placeholder.com/150/f66b97"
              },
              {
                "albumId": 1,
                "id": 6,
                "title": "accusamus ea aliquid et amet sequi nemo",
                "url": "https://via.placeholder.com/600/56a8c2",
                "thumbnailUrl": "https://via.placeholder.com/150/56a8c2"
              },
              {
                "albumId": 1,
                "id": 7,
                "title": "officia delectus consequatur vero aut veniam explicabo molestias",
                "url": "https://via.placeholder.com/600/b0f7cc",
                "thumbnailUrl": "https://via.placeholder.com/150/b0f7cc"
              },
              {
                "albumId": 1,
                "id": 8,
                "title": "aut porro officiis laborum odit ea laudantium corporis",
                "url": "https://via.placeholder.com/600/54176f",
                "thumbnailUrl": "https://via.placeholder.com/150/54176f"
              },
              {
                "albumId": 1,
                "id": 9,
                "title": "qui eius qui autem sed",
                "url": "https://via.placeholder.com/600/51aa97",
                "thumbnailUrl": "https://via.placeholder.com/150/51aa97"
              },
              {
                "albumId": 1,
                "id": 10,
                "title": "beatae et provident et ut vel",
                "url": "https://via.placeholder.com/600/810b14",
                "thumbnailUrl": "https://via.placeholder.com/150/810b14"
              },
              {
                "albumId": 2,
                "id": 51,
                "title": "non sunt voluptatem placeat consequuntur rem incidunt",
                "url": "https://via.placeholder.com/600/8e973b",
                "thumbnailUrl": "https://via.placeholder.com/150/8e973b"
              },
              {
                "albumId": 2,
                "id": 52,
                "title": "eveniet pariatur quia nobis reiciendis laboriosam ea",
                "url": "https://via.placeholder.com/600/121fa4",
                "thumbnailUrl": "https://via.placeholder.com/150/121fa4"
              },
              {
                "albumId": 3,
                "id": 137,
                "title": "et sit earum praesentium quas quis sint et",
                "url": "https://via.placeholder.com/600/41c3dc",
                "thumbnailUrl": "https://via.placeholder.com/150/41c3dc"
              },
              {
                "albumId": 3,
                "id": 138,
                "title": "vitae delectus sed",
                "url": "https://via.placeholder.com/600/ff79d0",
                "thumbnailUrl": "https://via.placeholder.com/150/ff79d0"
              }
            ]
        """.trimIndent()
        val expectedOne = 10
        val expectedTwo = 2
        val expectedThree = 2

        val repository = PhotoRepositoryImpl(MockPhotoDataSourceImpl(text))

        val list1 = repository.getPhotos(1)
        val list2 = repository.getPhotos(2)
        val list3 = repository.getPhotos(3)

        assertEquals(expectedOne, list1.size)
        assertEquals(expectedTwo, list2.size)
        assertEquals(expectedThree, list3.size)

    }
}