package _251125_dto_mapper.exercise1.repository

import _251125_dto_mapper.exercise1.data_source.StoreDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.Test

class StoreRepositoryImplTest {
    @Test
    fun `deleteInvalidData를 하면 null이거나 요소가 없는 객체는 제거한 리스트가 반환된다` = runTest {
        //given
        val storeDataSourceImpl = StoreDataSourceImpl()
        val storeRepositoryImpl = StoreRepositoryImpl(storeDataSourceImpl)

        //when
        val result = storeRepositoryImpl.deleteInvalidData()
        println(result.size)

        //println(storeDataSourceImpl.getAllStore().size)

        //then


    }

}