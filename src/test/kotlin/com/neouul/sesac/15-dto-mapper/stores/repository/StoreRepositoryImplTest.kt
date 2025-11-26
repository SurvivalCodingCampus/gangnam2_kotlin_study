package com.neouul.sesac.`15-dto-mapper`.stores.repository

import com.neouul.sesac.`15-dto-mapper`.stores.data_source.MockStoreRemoteDataSourceImpl
import com.neouul.sesac.`15-dto-mapper`.stores.data_source.RemoteDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class StoreRepositoryImplTest {
    private val mockDataSource: RemoteDataSource = MockStoreRemoteDataSourceImpl()
    private val storeRepository: StoreRepository = StoreRepositoryImpl(mockDataSource)

    @Test
    fun `getStores 메서드 성공 - MockStoreRemoteDataSourceImpl`() = runBlocking {
        // when
        val response = storeRepository.getStores()

        // then: 222 - 1(필드없음) - 5(null) = 216
        assertEquals(216, response.size)
    }
}