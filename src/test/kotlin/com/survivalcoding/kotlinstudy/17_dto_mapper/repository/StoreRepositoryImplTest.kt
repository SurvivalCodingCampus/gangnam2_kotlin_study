package com.survivalcoding.kotlinstudy.`17_dto_mapper`.repository

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source.StoreDataSource
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.StoreDto
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.Store
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class StoreRepositoryImplTest {

    private val dataSource = mockk<StoreDataSource>()
    private val repository = StoreRepositoryImpl(dataSource)

    @Test
    fun `유효한 store만 필터링`() = runTest {
        // given
        coEvery { dataSource.getStores() } returns listOf(
            StoreDto("addr1", "001", "2020-01-01", 37.0, 127.0, "약국1", "plenty", "2020-01-01", "01"),
            // createdAt 없음
            StoreDto("addr2", "002", null, 37.0, 127.0, "약국2", "empty", "2020-01-01", "01"),
            // remainStat 없음
            StoreDto("addr3", "003", "2020-01-01", 37.0, 127.0, "약국3", null, "2020-01-01", "01"),
            // stockAt 없음
            StoreDto("addr4", "004", "2020-01-01", 37.0, 127.0, "약국4", "some", null, "01")
        )

        val expected = Store(
            address = "addr1",
            createdAt = "2020-01-01",
            name = "약국1",
            remainStat = "plenty",
            stockAt = "2020-01-01"
        )

        // when
        val result = repository.getStores()


        // then
        assertEquals(1, result.size)
        assertEquals(expected, result[0])
    }

    @Test
    fun `DTO가 Model로 정상 변환`() = runTest {
        // given
        coEvery { dataSource.getStores() } returns listOf(
            StoreDto("서울 강남구", "001", "2020-01-01", 37.0, 127.0, "테스트약국", "some", "2020-01-01", "01")
        )

        val expected = Store(
            address = "서울 강남구",
            createdAt = "2020-01-01",
            name = "테스트약국",
            remainStat = "some",
            stockAt = "2020-01-01"
        )

        // when
        val result = repository.getStores()


        // then
        assertEquals(expected, result[0])
    }


    @Test
    fun `DataSource가 빈 리스트 - Repository도 빈 리스트`() = runTest {
        // given
        coEvery { dataSource.getStores() } returns emptyList()

        // when
        val result = repository.getStores()

        // then
        assertEquals(0, result.size)
    }
}
