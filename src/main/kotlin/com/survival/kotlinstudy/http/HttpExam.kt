package com.survival.kotlinstudy.http

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val client: HttpClient = HttpClientFactory.create()
    val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts/1")

    println(response.bodyAsText())
}


object HttpClientFactory {
    fun create(): HttpClient {
        // 코루틴 처리 되도록 하는 방식 -> CIO
        return HttpClient(CIO)
    }
}