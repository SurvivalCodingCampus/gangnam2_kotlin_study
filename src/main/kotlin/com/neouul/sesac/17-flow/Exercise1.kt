package com.neouul.sesac.`17-flow`

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // 연습문제 1
    val intFlow = flow {
        for (i in 1..5) {
            delay(100)
            println("Emitting $i")
            emit(i)
        }
    }

    intFlow
        .filter { it % 2 == 0 }
        .map { it * 10 }
        .collect { println(it) }
}