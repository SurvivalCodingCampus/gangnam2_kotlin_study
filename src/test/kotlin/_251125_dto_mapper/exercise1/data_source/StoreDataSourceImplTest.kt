package _251125_dto_mapper.exercise1.data_source

import _251125_dto_mapper.exercise1.FILEPATH
import _251125_dto_mapper.exercise1.dto.StoreDto
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class StoreDataSourceImplTest {
    lateinit var storeDataSourceImpl: StoreDataSourceImpl

    @Before
    fun `초기작업`() {
        storeDataSourceImpl = StoreDataSourceImpl()
    }

    @Test
    fun `getAllStore을 하면 서버로부터 모든 store목록을 가져온다`() = runTest {
        //given
        val file = File(FILEPATH).readText()
        //when
        val response = storeDataSourceImpl.getAllStore()
        //then
        assertEquals(HttpStatusCode.OK, response.statusCode)
        assertEquals(Json.decodeFromString<StoreDto>(file), response.body)
    }

}