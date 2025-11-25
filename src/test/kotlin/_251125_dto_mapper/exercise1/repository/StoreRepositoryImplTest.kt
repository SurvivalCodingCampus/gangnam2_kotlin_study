package _251125_dto_mapper.exercise1.repository

import _251125_dto_mapper.exercise1.FILEPATH
import _251125_dto_mapper.exercise1.data_source.StoreDataSourceImpl
import _251125_dto_mapper.exercise1.dto.StoreDto
import _251125_dto_mapper.exercise1.mapper.toStore
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class StoreRepositoryImplTest {
    @Test
    fun `deleteInvalidData를 하면 null이거나 요소가 없는 객체는 제거한 리스트가 반환된다`() = runTest {
        //given
        val storeDataSourceImpl = StoreDataSourceImpl()
        val storeRepositoryImpl = StoreRepositoryImpl(storeDataSourceImpl)
        //when
        val result = storeRepositoryImpl.deleteInvalidData()
        //then
        assertEquals(
            result,
            Json.decodeFromString<StoreDto>(File(FILEPATH).readText())
                .toStore().filter { it.remainStat.isNotEmpty() && it.stockAt.isNotEmpty() && it.createdAt.isNotEmpty() }
        )


    }

}