package com.survivalcoding.kotlinstudy.`16_network`.mock

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*

object ImageDataSourceMockEngine {

    fun fetchSuccess(bytes: ByteArray) = MockEngine { request ->
        respond(
            content = ByteReadChannel(bytes),
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "image/webp")
        )
    }
}
