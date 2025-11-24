package com.neouul.sesac.`14-network`.Exercise.core

import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.util.toMap
import kotlinx.serialization.json.Json

object ResponseFactory {
    suspend inline fun <reified T>create(response: HttpResponse): Response<T> {
        return Response<T>(response.status.value,
            response.headers.toMap(),
            Json.decodeFromString<T>(response.bodyAsText()),
        )
    }

    // DELETE 결과로 Unit 반환을 위한 오버로딩
    suspend fun create(response: HttpResponse): Response<Unit> {
        return Response<Unit>(response.status.value,
            response.headers.toMap(),
            Unit,
        )
    }
}