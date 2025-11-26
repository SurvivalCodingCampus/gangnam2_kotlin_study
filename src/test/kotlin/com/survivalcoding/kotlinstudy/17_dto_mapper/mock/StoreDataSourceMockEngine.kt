package com.survivalcoding.kotlinstudy.`17_dto_mapper`.mock

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*

object StoreDataSourceMockEngine {

    // GET /stores 성공
    fun getStoresSuccess() = MockEngine { request ->
        respond(
            content = ByteReadChannel(
                """
                {
                  "count": 2,
                  "stores": [
                    {
                      "addr": "서울시 강남구 테헤란로 1",
                      "code": "001",
                      "created_at": "2020-01-01 10:00:00",
                      "lat": 37.0,
                      "lng": 127.0,
                      "name": "약국 1",
                      "remain_stat": "plenty",
                      "stock_at": "2020-01-01 10:00:00",
                      "type": "01"
                    },
                    {
                      "addr": "서울시 서초구 반포대로 2",
                      "code": "002",
                      "created_at": "2020-01-02 11:00:00",
                      "lat": 37.1,
                      "lng": 127.1,
                      "name": "약국 2",
                      "remain_stat": "some",
                      "stock_at": "2020-01-02 11:00:00",
                      "type": "01"
                    }
                  ]
                }
                """.trimIndent()
            ),
            status = HttpStatusCode.OK,
            headers = headersOf("Content-Type", "application/json")
        )
    }

    // 2) GET /stores 성공 (stores = null → emptyList 처리해야 함)
    fun getStoresNull() = MockEngine { request ->
        respond(
            content = ByteReadChannel(
                """
                {
                  "count": 0,
                  "stores": null
                }
                """.trimIndent()
            ),
            status = HttpStatusCode.OK,
            headers = headersOf("Content-Type", "application/json")
        )
    }
}
