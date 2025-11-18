package com.luca.kotlinstudy._13_Async

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    launch { firstBird() }
    launch { secondBird() }
    launch { thirdBird() }
}

suspend fun firstBird() {
    repeat(4) {
        println("꾸우")
        delay(1000)
    }
}

suspend fun secondBird() {
    repeat(4) {
        println("까악")
        delay(2000)
    }
}

suspend fun thirdBird() {
    repeat(4) {
        println("짹짹")
        delay(3000)
    }
}
