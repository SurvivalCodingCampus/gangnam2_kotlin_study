package com.survival.kotlinstudy.asynchronous

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun bird1() {
    delay(1000)
    println("꾸우")
}

suspend fun bird2() {
    delay(2000)
    println("까악")
}

suspend fun bird3() {
    delay(3000)
    println("짹짹")
}

fun main(): Unit = runBlocking {
    val job = launch {
        launch {
            while (true) {
                bird1()
            }
        }
        launch {
            while (true) {
                bird2()
            }
        }
        launch {
            while (true) {
                bird3()
            }
        }
    }
    delay(10000)
    job.cancel()
    println("10초 지남~")
//    async { repeat(4) { bird1() } }
//    async { repeat(4) { bird2() } }
//    async { repeat(4) { bird3() } }
}