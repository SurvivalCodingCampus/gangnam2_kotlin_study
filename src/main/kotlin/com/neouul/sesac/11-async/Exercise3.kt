package com.neouul.sesac.`11-async`

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(): kotlin.Unit = runBlocking {
    // 1. 시작 시점의 밀리초(ms)를 기록
//    val startTime = System.currentTimeMillis()

    val bird1 = launch {
        while (true) {
            delay(1000L)
            println("꾸우")
        }
    }

    val bird2 = launch {
        while (true) {
            delay(2000L)
            println("까악")
        }
    }

    val bird3 = launch {
        while (true) {
            delay(3000L)
            println("짹짹")
        }
    }

    // 경과 시간을 측정하고 출력하는 launch 블록
//    val job = launch {
//        while (true) {
//            // 현재 시점의 밀리초
//            val currentTime = System.currentTimeMillis()
//            // 시작 시점으로부터의 경과 시간 (밀리초)
//            val elapsedTimeMillis = currentTime - startTime
//            // 초 단위로 변환
//            val elapsedTimeSeconds = elapsedTimeMillis / 1000.0
//
//            println("${String.format("%.1f", elapsedTimeSeconds)}초 ======")
//            delay(1000L)
//        }
//    }

    launch {
        val time = measureTimeMillis {
            delay(10000L)
            bird1.cancel()
            bird2.cancel()
            bird3.cancel()
        }
//        job.cancel()
        println("$time ms : 코루틴 취소")
    }

}
