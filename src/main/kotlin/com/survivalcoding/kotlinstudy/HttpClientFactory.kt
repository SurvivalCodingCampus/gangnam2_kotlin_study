package com.survivalcoding.kotlinstudy

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO)
    }
}