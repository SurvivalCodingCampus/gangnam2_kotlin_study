package _251125_dto_mapper.exercise1.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*

object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO)
    }
}