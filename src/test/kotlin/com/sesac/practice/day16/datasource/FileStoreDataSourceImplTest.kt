package com.sesac.practice.day16.datasource

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class FileStoreDataSourceImplTest {
    @Test
    fun `mask_store_json 에서 StoreDto 리스트를 가져온다`() = runTest {
        // given
        val pathname = "data/mask_store.json"
        val dataSource = FileStoreDataSourceImpl(pathname)

        // when
        val response = dataSource.getStores()

        // then
        assertEquals(200, response.statusCode)
        assertEquals(222, response.body?.stores?.size)
    }
}
