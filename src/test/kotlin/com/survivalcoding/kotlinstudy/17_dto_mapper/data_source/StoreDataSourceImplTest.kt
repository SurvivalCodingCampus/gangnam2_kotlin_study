package com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.mock.StoreDataSourceMockEngine
import io.ktor.client.*
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class StoreDataSourceImplTest {
    @Test
    fun `stores 정상 반환 - 리스트 반환`() = runTest {
        val client = HttpClient(StoreDataSourceMockEngine.getStoresSuccess())
        val dataSource = StoreDataSourceImpl(client)

        val result = dataSource.getStores()

        assertEquals(2, result.size)
    }

    @Test
    fun `stores 정상 반환 - 빈 리스트`() = runTest {
        val client = HttpClient(StoreDataSourceMockEngine.getStoresNull())
        val dataSource = StoreDataSourceImpl(client)

        val result = dataSource.getStores()

        assertEquals(0, result.size)
    }
}
