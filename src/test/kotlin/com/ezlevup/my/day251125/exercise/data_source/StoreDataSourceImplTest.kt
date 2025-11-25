package com.ezlevup.my.day251125.exercise.data_source

import com.ezlevup.my.day251125.exercise.dto.MaskStoreDto
import com.ezlevup.my.day251125.exercise.mapper.toStore
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class StoreDataSourceImplTest {

    private lateinit var storeJsonText: String
    private lateinit var mockEngine: MockEngine
    private lateinit var mockStores: MaskStoreDto

    @Before
    fun setUp() {
        storeJsonText = """
            {
  "count": 2,
  "stores": [
    {
      "addr": "서울특별시 강북구 솔매로 38 (미아동)",
      "code": "11817488",
      "created_at": "2020/07/03 11:00:00",
      "lat": 37.6254369,
      "lng": 127.0164096,
      "name": "승약국",
      "remain_stat": "plenty",
      "stock_at": "2020/07/02 18:05:00",
      "type": "01"
    },
    {
      "addr": "서울특별시 강북구 삼양로 247 3층 (미아동)",
      "code": "12856941",
      "created_at": "2020/07/03 11:00:00",
      "lat": 37.6255182,
      "lng": 127.017747,
      "name": "대지약국",
      "remain_stat": "plenty",
      "stock_at": "2020/07/03 10:45:00",
      "type": "01"
    }]}
        """.trimIndent()
        mockStores = Json.decodeFromString<MaskStoreDto>(storeJsonText)
        mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel(storeJsonText),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
    }

    @After
    fun tearDown() {

    }

    @Test
    fun getStores(): Unit = runBlocking {
        // given
        //val client: HttpClient = HttpClientProvider.client
        val client: HttpClient = HttpClient(mockEngine)
        val dataSource = StoreDataSourceImpl(client)

        // when
        val result = dataSource.getStores()

        // then
        assertEquals(HttpStatusCode.OK, result.status)
        assertEquals(mockStores.stores?.count(), result.body?.stores?.count())
        println(result.body?.stores?.count())
    }

    @Test
    fun `mapper 테스트`(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(mockEngine)
        val dataSource = StoreDataSourceImpl(client)

        // when
        val result = dataSource.getStores()

        // then
        val stores = result.body?.toStore()
        assertEquals(HttpStatusCode.OK, result.status)
        assertEquals(mockStores.stores?.count(), stores?.count())
    }

}
