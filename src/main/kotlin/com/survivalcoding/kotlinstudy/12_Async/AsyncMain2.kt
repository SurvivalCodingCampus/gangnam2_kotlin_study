package com.survivalcoding.kotlinstudy.`12_Async`

import kotlinx.coroutines.*

fun main() = runBlocking(Dispatchers.Main) {
    val job: Job = launch(Dispatchers.Main) {
        delay(1000)

        withContext(Dispatchers.IO) {
            println("world")
        }

        launch {

        }

        launch {

        }
    }

    val result: Deferred<String> = async {
        delay(1000)
        "Hello"
    }

    println("hello")

}

fun myFunc() {
//    delay(1000)
}