package com.ezlevup.my.day251118

import kotlinx.coroutines.*

class BlockingMain {
}

fun main() = runBlocking {
    val job: Job = launch {
        delay(1000)
        println("hello")
    }

    async {
        delay(1000)
        "hello"
    }

    println("world")
}

fun runMain(): Job = GlobalScope.launch {
    val data = Weathers.tomorrow()
    println("lee")
}

suspend fun Weathers.tomorrow(): String {
    delay(1000)
    return "good"
}

object Weathers


