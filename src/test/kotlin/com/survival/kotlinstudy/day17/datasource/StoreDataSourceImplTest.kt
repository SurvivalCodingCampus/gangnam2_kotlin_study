package com.survival.kotlinstudy.day17.datasource

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class StoreDataSourceImplTest {
    private val content = """
        {
          "count": 12,
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
            },
            {
              "addr": "서울특별시 강북구 삼양로 255 (미아동)",
              "code": "11819723",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6261612,
              "lng": 127.0180494,
              "name": "청구약국",
              "remain_stat": "plenty",
              "stock_at": "2020/07/03 10:40:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 솔샘로 254 2층 2호 (미아동, 삼양아케이트)",
              "code": "11888571",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.627357,
              "lng": 127.018375,
              "name": "민들레약국",
              "remain_stat": "plenty",
              "stock_at": "2020/06/29 08:12:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 삼양로77길 25 (수유동)",
              "code": "11845929",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6297115,
              "lng": 127.0168913,
              "name": "우정약국",
              "remain_stat": "plenty",
              "stock_at": "2020/07/01 15:35:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 삼양로 293 (수유동)",
              "code": "11817968",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6297559,
              "lng": 127.0177412,
              "name": "삼천약국",
              "remain_stat": "plenty",
              "stock_at": "2020/07/03 08:45:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 도봉로67길 34 (미아동)",
              "code": "11819693",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6302571,
              "lng": 127.022447,
              "name": "수유태평양약국",
              "remain_stat": "plenty",
              "stock_at": "2020/07/02 09:46:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 인수봉로 142 (수유동)",
              "code": "11819154",
              "created_at": "2020/06/28 23:55:00",
              "lat": 37.6323392,
              "lng": 127.0138353,
              "name": "한사랑온누리약국",
              "remain_stat": "few",
              "stock_at": "2020/06/22 21:11:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 삼양로 309 (수유동)",
              "code": "12826456",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6309979,
              "lng": 127.0175749,
              "name": "푸른약국",
              "remain_stat": "plenty",
              "stock_at": "2020/07/01 13:40:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 삼양로 319 1층 (수유동)",
              "code": "12861448",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6318474,
              "lng": 127.0175079,
              "name": "서울진약국",
              "remain_stat": "plenty",
              "stock_at": "2020/07/03 09:02:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 수유로 9 (수유동)",
              "code": "12846821",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.631947,
              "lng": 127.0180892,
              "name": "온누리대성약국",
              "remain_stat": "plenty",
              "stock_at": "2020/06/30 15:09:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 덕릉로 17 (수유동)",
              "code": "11816856",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6341305,
              "lng": 127.01554,
              "name": "호림프라자약국",
              "remain_stat": "plenty",
              "stock_at": "2020/06/29 09:16:00",
              "type": "01"
            }
          ]
        }
    """.trimIndent()
    private val mockEngine = MockEngine { request ->
        respond(
            content = content,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }


    private val client = HttpClient(mockEngine)
    val datasource = StoreDataSourceImpl(client)

    @Test
    fun `getStores() 데이터를 잘 가져오는지 확인 테스트`() = runTest {
        val response = datasource.getStores()

        assertEquals(response.count, 12)
        assertEquals(response.stores?.size, 12)
    }

}