package com.survivalcoding.kotlinstudy.`16_http`.practice.post.data_source

import io.ktor.client.engine.mock.*
import java.io.IOException

object NetworkErrorMockEngine {

    val engine: MockEngine = MockEngine { request ->
        throw IOException("Mock 네트워크 오류: ${request.method.value} ${request.url}")
    }
}