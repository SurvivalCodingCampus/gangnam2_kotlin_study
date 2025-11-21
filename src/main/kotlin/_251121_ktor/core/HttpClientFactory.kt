package _251121_ktor.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*

object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO)
    }
}