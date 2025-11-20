package com.hhp227.kotlinstudy.`14_repository`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class PhotoDataSourceTest {
    val mockPhotoDataSource = MockPhotoDataSourceImpl(filename = "photos.json")

    @Test
    fun `파일이 존재하는지 확인`() {
        val photosJson = this::class.java.classLoader.getResource("photos.json")

        assertNotNull(photosJson, "photos.json 파일이 존재해야 합니다.")
    }

    @Test
    fun `Photo리스트를 모두 불러오는지 테스트`() = runTest {
        val photoList = mockPhotoDataSource.getAllPhotos()

        assertIs<List<Photo>>(photoList)
    }

    @Test
    fun `Photo리스트 크기가 일치한지 테스트`() = runTest {
        val photoList = mockPhotoDataSource.getAllPhotos()
        val expected = 5000

        assertEquals(expected, photoList.size)
    }

    @Test
    fun `Photo리스트 첫번째 아이템이 일치한지 테스트`() = runTest {
        val expected = Photo(
            albumId = 1,
            id = 1,
            title = "accusamus beatae ad facilis cum similique qui sunt",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/150/92c952"
        )
        val photoList = mockPhotoDataSource.getAllPhotos()
        val firstPhoto = photoList.first()

        assertEquals(expected, firstPhoto)
    }

    @Test
    fun `Comment리스트 마지막 아이템이 일치한지 테스트`() = runTest {
        val expected = Photo(
            albumId = 100,
            id = 5000,
            title = "error quasi sunt cupiditate voluptate ea odit beatae",
            url = "https://via.placeholder.com/600/6dd9cb",
            thumbnailUrl = "https://via.placeholder.com/150/6dd9cb"
        )
        val photoList = mockPhotoDataSource.getAllPhotos()
        val lastPhoto = photoList.last()

        assertEquals(expected, lastPhoto)
    }
}