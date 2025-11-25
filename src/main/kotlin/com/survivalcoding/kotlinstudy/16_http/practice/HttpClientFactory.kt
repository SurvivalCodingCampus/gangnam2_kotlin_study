package com.survivalcoding.kotlinstudy.`16_http`.practice

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO)
    }
}
