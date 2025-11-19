package com.sesac.kotlinstudy.day12.async

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job: Job = launch {
        delay(1000)
        println("World!")
    }

    val result: Deferred<String> = async {
        delay(1000)
        "Hello"
    }

    println("Hello")
}

fun myFunc() {
    // delay(1000) // error
}
