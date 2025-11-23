package com.survivalcoding.kotlinstudy.`16_network`.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true    // 추가 필드 무시하고 파싱하기 위함
                    isLenient = true    // Json 문법 느슨하게 허용
                })
            }
        }
    }
}


suspend inline fun <reified T> HttpResponse.toCustomResponse(): Response<T> {

    // 상태코드
    val statusCode = this.status.value

    // 헤더
    val headers = this.headers.entries()
        .associate { it.key to it.value }

    // body 디코딩
    val body = Json.decodeFromString<T>(this.bodyAsText())

    // Respons 생성
    return Response(
        statusCode = statusCode,
        headers = headers,
        body = body
    )
}