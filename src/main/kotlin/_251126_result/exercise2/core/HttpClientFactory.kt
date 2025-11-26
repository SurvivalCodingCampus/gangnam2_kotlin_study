package _251126_result.exercise2.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*

object HttpClientFactory {
    fun generate(): HttpClient {
        return HttpClient(CIO)
    }
}