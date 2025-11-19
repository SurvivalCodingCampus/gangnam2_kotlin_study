package com.survivalcoding.kotlinstudy.`13_async`.practice

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val birdSound = launch {
        val pigeon = async {
            while (true) {
                println(pigeonSound())
            }
        }
        val crow = async {
            while (true) {
                println(crowSound())
            }
        }
        val sparrow = async {
            while (true) {
                println(sparrowSound())
            }
        }

        pigeon.await()
        crow.await()
        sparrow.await()
    }

    launch {
        delay(10000)
        birdSound.cancel()
        println("울음소리가 멎었다")
    }
}

suspend fun pigeonSound(): String {
    delay(1000)
    return "꾸우"
}

suspend fun crowSound(): String {
    delay(2000)
    return "까악"
}

suspend fun sparrowSound(): String {
    delay(3000)
    return "짹짹"
}