package com.ezlevup.my.core

import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

data class Response<T>(
    val status: HttpStatusCode,
    val headers: Headers,
    val body: T? = null,
)

const val EMPTY_JSON_VALUE = "{}"

suspend inline fun <reified T> HttpResponse.toResponse(): Response<T> {
    val statusCode = this.status
    val headers = this.headers
    val json = this.bodyAsText()

    if (json.isEmpty() || json == EMPTY_JSON_VALUE) {
        return Response(statusCode, headers)
    }

    return try {
        Response(
            statusCode,
            headers,
            Json.decodeFromString<T>(json),
        )
    } catch (e: SerializationException) {
        println(e.toString())
        Response(statusCode, headers)
    }
}