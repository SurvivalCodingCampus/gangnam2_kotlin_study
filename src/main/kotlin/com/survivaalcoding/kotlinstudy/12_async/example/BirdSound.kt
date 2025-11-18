package com.survivaalcoding.kotlinstudy.`12_async`.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job1 = launch {
        var count = 5
        while (count != 0) {
            count--
            Bird.birdOne()
        }
    }

    val job2 = launch {
        var count = 5
        while (count != 0) {
            count--
            Bird.birdTwo()
        }
    }

    val job3 = launch {
        var count = 5
        while (count != 0) {
            count--
            Bird.birdThree()
        }
    }

    launch {
        delay(10000)
        listOf(job1, job2, job3).forEach {
            it.cancel()
        }
    }
}

object Bird {
    suspend fun birdOne() {
        delay(1000)
        println("꾸우")
    }

    suspend fun birdTwo() {
        delay(2000)
        println("까악")
    }

    suspend fun birdThree() {
        delay(3000)
        println("짹짹")
    }
}
