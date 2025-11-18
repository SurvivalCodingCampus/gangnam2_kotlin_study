package com.survivalcoding.kotlinstudy.`13_async`

import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


// 연습문제 2. 코루틴을 사용한 새소리 타이이밍 재현
fun main() = runBlocking {
    val job = launch {
        launch {
            while (isActive) {
                println("꾸우")
                delay(1000L)
            }
        }
        launch {
            while (isActive) {
                println("까악")
                delay(2000L)
            }
        }
        launch {
            while (isActive) {
                println("짹짹")
                delay(3000L)
            }
        }
    }

    // 연습문제 3. 10초 반복
    delay(10000L)
    println("10초 끝")
    job.cancel()    // 그만하라는 요청
    job.join()  // 코루틴이 완전히 종료될 때까지 기다리는 역할

    // 이렇게도가능
    // job.cancelAndJoin()
}