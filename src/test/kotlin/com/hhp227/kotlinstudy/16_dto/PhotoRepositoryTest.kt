package com.hhp227.kotlinstudy.`16_dto`

import kotlinx.coroutines.test.runTest
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class PhotoRepositoryTest {
    private lateinit var photoRepository: PhotoRepository

    @Test
    fun `Mapper가 정상적으로 Model로 변환되는지 테스트`() {
        val dto = PhotoDto(
            id = 10,
            type = "image",
            createdAt = "2020-12-12",
            url = "url.com",
            caption = "caption"
        )
        val model = dto.toModel()

        assertNotNull(model)
        assertEquals("10", model.id)
        assertEquals(PhotoType.Image, model.type)
        assertEquals(LocalDate.of(2020, 12, 12), model.createdAt)
    }

    @Test
    fun `type이 null이면 Unknown으로 처리되는지 테스트`() {
        val dto = PhotoDto(id = 10, type = null, createdAt = "2020-01-01")
        val model = dto.toModel() ?: return

        assertEquals(PhotoType.Unknown, model.type)
    }

    @Test
    fun `날짜 형식 에러면 null 반환되는지 테스트`() {
        val dto = PhotoDto(id = 12, type = "article", createdAt = "INVALID_DATE")
        val model = dto.toModel()

        assertNull(model)
    }

    @Test
    fun `id 또는 created_at이 null이면 null 반환되는지 테스트`() {
        val dto1 = PhotoDto(id = null, createdAt = "2020-01-01")
        val dto2 = PhotoDto(id = 1, createdAt = null)

        assertNull(dto1.toModel())
        assertNull(dto2.toModel())
    }

    @Test
    fun `Repository가 DTO를 Model로 올바르게 변환해서 반환하는지 테스트 - mock_data1`() = runTest {
        val photoDataSource = PhotoDataSourceImpl("mock_data1.json")
        photoRepository = PhotoRepositoryImpl(photoDataSource)
        val photos = photoRepository.getPhotos()

        assertEquals(3, photos.size)
        assertEquals("1", photos[0].id)
        assertEquals(PhotoType.Article, photos[0].type)
        assertEquals(LocalDate.of(2020, 1, 1), photos[0].createdAt)
    }

    @Test
    fun `Repository가 잘못된 데이터(mock_data2)도 Unknown 타입 처리하여 정상 반환하는지 테스트`() = runTest {
        val photoDataSource = PhotoDataSourceImpl("mock_data2.json")
        photoRepository = PhotoRepositoryImpl(photoDataSource)
        val photos = photoRepository.getPhotos()

        assertEquals(3, photos.size)
        assertEquals(PhotoType.Unknown, photos[1].type)
        assertEquals(PhotoType.Unknown, photos[2].type)
    }
}