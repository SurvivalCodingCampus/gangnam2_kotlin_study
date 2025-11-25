package com.ezlevup.my.day251121

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO)
    }
}


suspend fun main() {
    //val client = HttpClient(CIO)
    val client = HttpClientFactory.create()
    val response: HttpResponse = client.get("https://ktor.io/")
    println(response.status)
    client.close()
}

