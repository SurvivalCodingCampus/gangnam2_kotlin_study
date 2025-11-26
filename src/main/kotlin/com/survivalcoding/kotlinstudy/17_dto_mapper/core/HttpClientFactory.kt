package com.survivalcoding.kotlinstudy.`17_dto_mapper`.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


object JsonConfig {
    val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true    // 추가 필드 무시하고 파싱하기 위함
        isLenient = true    // Json 문법 느슨하게 허용
    }
}


object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(JsonConfig.json)
                json(JsonConfig.json, contentType = ContentType.Text.Plain) // 문제 url 에서 text 가 plain 으로 들어옴
            }
        }
    }
}
