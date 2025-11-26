package com.survivalcoding.kotlinstudy.`18_result`.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json


object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true    // 추가 필드 무시하고 파싱하기 위함
                    isLenient = true    // Json 문법 느슨하게 허용
                }
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 10_000 // Http 요청 시간 초과 처리 자동
            }
        }
    }
}
