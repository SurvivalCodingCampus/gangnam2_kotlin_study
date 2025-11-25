package com.hhp227.kotlinstudy.`16_dto`

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class StoreRepositoryTest {
    private lateinit var storeRepository: StoreRepository

    @Test
    fun `유효한 DTO만 Store 도메인 모델로 반환되는지 테스트`() = runTest {
        val storeDataSource: StoreDataSource = StoreDataSourceImpl("mask_store.json")
        storeRepository = StoreRepositoryImpl(storeDataSource)
        val result = storeRepository.getStores()

        assertEquals(216, result.size)
    }

    @Test
    fun `Mapper가 null을 반환하면 제외되는지 테스트`() = runTest {
        val storeDataSource: StoreDataSource = StoreDataSourceImpl("mask_store.json")
        storeRepository = StoreRepositoryImpl(storeDataSource)
        // 은혜약국은 2개가 있는데 한개의 데이터가 속성 몇개가 없음
        val expected = 1
        val result = storeRepository.getStores().filter { it.name == "은혜약국" }

        assertEquals(expected, result.size)
    }

    @Test
    fun `dto가 정상일 때 모델로 성공적으로 변환되는지 테스트`() {
        val dto = StoreDto(
            name = "약국A",
            addr = "서울",
            lat = 37.0,
            lng = 127.0,
            remainStat = "some",
            stockAt = "2025-01-01",
            createdAt = "2025-01-01"
        )
        val domain = dto.toModel()

        assertEquals("약국A", domain!!.name)
        assertEquals("서울", domain.address)
        assertEquals(37.0, domain.latitude, 0.0)
        assertEquals(127.0, domain.longitude, 0.0)
        assertEquals("some", domain.remainStat)
        assertEquals("2025-01-01", domain.stockAt)
    }

    @Test
    fun `필수값 누락 시 null 반환되는지 테스트`() {
        val dto = StoreDto(
            name = null,
            addr = "서울",
            lat = 37.0,
            lng = 127.0,
            remainStat = "some",
            stockAt = "2025-01-01"
        )
        val domain = dto.toModel()

        assertNull(domain)
    }
}