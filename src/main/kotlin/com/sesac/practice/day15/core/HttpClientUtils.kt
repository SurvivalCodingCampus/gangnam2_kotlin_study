package com.sesac.practice.day15.core

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.statement.*
import io.ktor.util.*
import kotlinx.serialization.json.Json

object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO)
    }
}

const val EMPTY_JSON_VALUE = "{}"

suspend inline fun <reified T> HttpResponse.toResponse(): Response<T> {
    val statusCode = this.status.value
    val headerMap = this.headers.toMap()
    val json = this.body<String>()

    if (json == EMPTY_JSON_VALUE) {
        return Response(statusCode, headerMap)
    }

    return Response(
        statusCode,
        headerMap,
        Json.decodeFromString<T>(json),
    )
}
