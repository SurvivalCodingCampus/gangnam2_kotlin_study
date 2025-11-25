package com.survival.kotlinstudy.day17.repository

import com.survival.kotlinstudy.day17.datasource.StoreDataSource
import com.survival.kotlinstudy.day17.dto.StoreDto
import com.survival.kotlinstudy.day17.dto.StoreListDto
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals

class StoreRepositoryImplTest {
    private val repository = StoreRepositoryImpl(MockStoreDataSourceImpl())


    @Test
    fun `getStores() 시 유효한 데이터만 반환하는지 테스트 `() = runTest {
        val expectedStoreCount = 2
        val stores = repository.getStores()


        assertEquals(expectedStoreCount,stores.size)
    }
}

class MockStoreDataSourceImpl : StoreDataSource {
    private val store1: StoreDto = Json.decodeFromString(
        """
        {
      "addr": "서울특별시 도봉구 도봉로113길 16 (쌍문동)",
      "code": "11819537",
      "created_at": null,
      "lat": 37.648276,
      "lng": 127.0332905,
      "name": "신신약국",
      "remain_stat": null,
      "stock_at": null,
      "type": "01"
    }
    """.trimIndent()
    )
    private val store2: StoreDto = Json.decodeFromString(
        """
        {
      "addr": "서울특별시 도봉구 도봉로 471 (쌍문동)",
      "code": "12840874",
      "created_at": "2020/07/03 11:00:00",
      "lat": 37.6478431,
      "lng": 127.0338935,
      "name": "무지개온누리약국",
      "remain_stat": "plenty",
      "stock_at": "2020/07/03 08:15:00",
      "type": "01"
    }
    """.trimIndent()
    )
    private val store3: StoreDto = Json.decodeFromString(
        """
        {
      "addr": "서울특별시 도봉구 도봉로 468 (창동)",
      "code": "11819383",
      "created_at": "2020/07/03 11:00:00",
      "lat": 37.6473897,
      "lng": 127.0343912,
      "name": "백운약국",
      "remain_stat": "plenty",
      "stock_at": "2020/07/03 08:57:00",
      "type": "01"
    }
    """.trimIndent()
    )

    private val storeList = StoreListDto(
        count = 1,
        stores = listOf(store1, store2, store3)
    )

    override suspend fun getStores(): StoreListDto {
        return storeList
    }

}