package com.survivalcoding.kotlinstudy.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*

object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO) {
            // 매직
//            install(ContentNegotiation) {
//                json()
//            }
        }
    }
}