package com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MockPhotoDataSourceImplTest {
    @Test
    fun `Mock DataSource - 전체 PhotoDto 개수 체크`() = runTest {
        // given
        val dataSource = MockPhotoDataSourceImpl()

        // when
        val result = dataSource.getPhotos()

        // then
        assertEquals(6, result.size)
    }

    @Test
    fun `Mock DataSource - id String, Int 모두 정상 동작`() = runTest {
        // givne
        val dataSource = MockPhotoDataSourceImpl()

        // when
        val result = dataSource.getPhotos()

        val first = result.first()
        val fourth = result[3]

        // then
        // DTO를 테스트 중이므로 Mapper를 거치기 전
        // 1 → "1"
        assertEquals("1", first.id)

        // "4" → 그대로 "4"
        assertEquals("4", fourth.id)
    }

    @Test
    fun `Mock DataSource - type null, 누락 필드도 파싱`() = runTest {
        // given
        val dataSource = MockPhotoDataSourceImpl()

        //when
        val result = dataSource.getPhotos()

        // id=5 인 요소(type=null)
        val fifth = result[4]

        // then
        // DTO를 테스트 중이므로 Mapper를 거치기 전
        assertEquals("5", fifth.id)
        assertEquals(null, fifth.type)
        assertNotNull(fifth.url)
    }
}
