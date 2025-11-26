package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.repository

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.datasource.StoreDataSourceImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals

private const val MOCK_DATA = """{
  "count": 2,
  "stores": [
    {
      "addr": "서울특별시 강북구 솔매로 38 (미아동)",
      "code": "11817488",
      "created_at": "2020/07/03 11:00:00",
      "lat": 37.6254369,
      "lng": 127.0164096,
      "name": "승약국",
      "remain_stat": "",
      "stock_at": null,
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
    }
  ]
}"""

class StoreRepositoryImplTest {
    val mockEngine = MockEngine { request ->
        respond(
            content = MOCK_DATA,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
        )
    }
    val httpClient = HttpClient(mockEngine) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }
    val dataSource = StoreDataSourceImpl(httpClient)
    val repository = StoreRepositoryImpl(dataSource)

    @Test
    fun `정상적인 데이터들만 조회한다`() = runTest {
        // given

        // when
        val actual = repository.getStores()

        // then
        assertEquals(1, actual.size)
    }
}