package com.survivalcoding.kotlinstudy.`16_network`.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.util.concurrent.CancellationException


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
    val body = try {
        JsonConfig.json.decodeFromString<T>(this.bodyAsText())

    } catch (e: CancellationException) {
        throw e // 코루틴 취소

    } catch (e: SerializationException) {
        null    // Json 디코딩 실패
    }

    // Response 생성
    return Response(
        statusCode = statusCode,
        headers = headers,
        body = body
    )
}