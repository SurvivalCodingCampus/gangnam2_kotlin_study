package com.survivalcoding.kotlinstudy.`14_http`

import com.survivalcoding.kotlinstudy.core.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val client: HttpClient = HttpClientFactory.create();

    val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts/1")

    println(response)
}
