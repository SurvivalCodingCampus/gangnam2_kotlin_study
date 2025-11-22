package com.neouul.sesac.`14-network`.Exercise.core

import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.util.toMap

object ResponseFactory {
    suspend fun create(response: HttpResponse): Response<String> {
        return Response<String>(response.status.value,
            response.headers.toMap(),
            response.bodyAsText(),
        )
    }
}