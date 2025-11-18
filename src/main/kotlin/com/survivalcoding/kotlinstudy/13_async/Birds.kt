package com.survivalcoding.kotlinstudy.`13_async`

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


// 연습문제 2. 코루틴을 사용한 새소리 타이이밍 재현
fun main() = runBlocking {
    val bird1 = launch {
        repeat(4) {
            println("꾸우")
            delay(1000L)
        }
    }

    val bird2 = launch {
        repeat(4) {
            println("까악")
            delay(2000L)
        }
    }

    val bird3 = launch {
        repeat(4) {
            println("짹짹")
            delay(3000L)
        }
    }
}
