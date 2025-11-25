package com.sesac.practice.day16.repository

import com.sesac.practice.day16.core.Response
import com.sesac.practice.day16.datasource.StoreDataSource
import com.sesac.practice.day16.dto.StoreDto
import com.sesac.practice.day16.dto.StoresDto
import io.mockk.MockKAnnotations
import io.mockk.bdd.coGiven
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class StoreRepositoryImplTest {

    @MockK
    lateinit var dataSource: StoreDataSource

    @InjectMockKs
    lateinit var repository: StoreRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `유효한 데이터인 Store 리스트를 가져온다`() = runTest {
        // given

        coGiven { dataSource.getStores() } returns Response(
            200,
            mapOf(),
            StoresDto(
                2,
                listOf(
                    StoreDto(
                        addr = "서울특별시 강북구 솔매로 38 (미아동)",
                        code = "11817488",
                        createdAt = "2020/07/03 11:00:00",
                        lat = 37.6254369,
                        lng = 127.0164096,
                        name = "승약국",
                        remainStat = "plenty",
                        stockAt = "2020/07/02 18:05:00",
                        type = "01",
                    ),
                    StoreDto(
                        addr = "서울특별시 강북구 삼양로 247 3층 (미아동)",
                        code = "12856941",
                        createdAt = "2020/07/03 11:00:00",
                        lat = 37.6255182,
                        lng = 127.017747,
                        name = "대지약국",
                        remainStat = "plenty",
                        stockAt = "2020/07/03 10:45:00",
                        type = "01",
                    ),
                ),
            ),
        )

        // when
        val stores = repository.getStores()

        // then
        assertEquals(2, stores.size)
    }

    @Test
    fun `유효하지 않은 데이터는 제외하고 가져온다`() = runTest {
        // given

        coGiven { dataSource.getStores() } returns Response(
            200,
            mapOf(),
            StoresDto(
                2,
                listOf(
                    StoreDto(
                        addr = "서울특별시 강북구 솔매로 38 (미아동)",
                        code = "11817488",
                        createdAt = "2020/07/03 11:00:00",
                        lat = 37.6254369,
                        lng = 127.0164096,
                        name = "승약국",
                        remainStat = "plenty",
                        stockAt = "2020/07/02 18:05:00",
                        type = "01",
                    ),
                    StoreDto(
                        createdAt = null,
                        remainStat = "plenty",
                        stockAt = "2020/07/02 18:05:00",
                    ),
                    StoreDto(
                        createdAt = "invalid createdAt",
                        remainStat = "plenty",
                        stockAt = "2020/07/02 18:05:00",
                    ),
                    StoreDto(
                        createdAt = "2020/07/03 11:00:00",
                        remainStat = null,
                        stockAt = "2020/07/02 18:05:00",
                    ),
                    StoreDto(
                        createdAt = "2020/07/03 11:00:00",
                        remainStat = "",
                        stockAt = "2020/07/02 18:05:00",
                    ),
                    StoreDto(
                        createdAt = "2020/07/03 11:00:00",
                        remainStat = "plenty",
                        stockAt = null,
                    ),
                    StoreDto(
                        createdAt = "2020/07/03 11:00:00",
                        remainStat = "plenty",
                        stockAt = "invalid stockAt",
                    ),
                ),
            ),
        )

        // when
        val stores = repository.getStores()

        // then
        assertEquals(1, stores.size)
    }
}
