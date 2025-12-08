package com.survivalcoding.kotlinstudy.`20_flow`

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val flow = flow {
        for (i in 1..5) {
            delay(100)
            emit(i)
        }
    }

    flow
        .filter { it % 2 == 0 }  // 짝수만 통과
        .map { it * 10 }        // 10배 증가
        .collect {
            println(it)     // 수집하여 출력
        }
}