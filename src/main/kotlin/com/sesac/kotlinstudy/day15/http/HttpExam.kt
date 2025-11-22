package com.sesac.kotlinstudy.day15.http

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val client = HttpClientFactory.create()

    val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts/1")

    println(response.bodyAsText())
}

object HttpClientFactory {
    fun create(): HttpClient {
        // 코루틴 처리 되도록
        return HttpClient(CIO)
    }
}
