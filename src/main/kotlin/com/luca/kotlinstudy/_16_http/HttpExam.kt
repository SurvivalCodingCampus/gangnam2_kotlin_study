package com.luca.kotlinstudy._16_http
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val client: HttpClient = HttpClientFactory.create()

    val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts/1")

    println(response)
}

object HttpClientFactory {
    fun create(): HttpClient {
        // 코루틴 처리 되도록
        return HttpClient(CIO)
    }
}