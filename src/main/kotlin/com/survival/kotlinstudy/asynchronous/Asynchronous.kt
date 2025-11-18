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
    launch {
        repeat(4) {
            bird1()
        }
    }
    launch {
        repeat(4) {
            bird2()
        }
    }
    launch {
        repeat(4) {
            bird3()
        }
    }
//    async { repeat(4) { bird1() } }
//    async { repeat(4) { bird2() } }
//    async { repeat(4) { bird3() } }
}