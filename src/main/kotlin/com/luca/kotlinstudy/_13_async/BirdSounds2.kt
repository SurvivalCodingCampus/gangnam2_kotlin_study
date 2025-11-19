package com.luca.kotlinstudy._13_async

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val bird1 = launch {
        while (true) {
            println("꾸우")
            delay(1000)
        }
    }
    val bird2 = launch {
        while (true) {
            println("까악")
            delay(2000)
        }
    }
    val bird3 = launch {
        while (true) {
            println("짹짹")
            delay(3000)
        }
    }

    delay(10000)
    bird1.cancel()
    bird2.cancel()
    bird3.cancel()

}
