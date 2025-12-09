package com.neouul.sesac.`17-flow`

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // 연습문제 2
    val flowA = flow {
        repeat(3) { index ->
            delay(300)
            println("Emitting A${index}")
            emit("A${index}")
        }
    }

    val flowB = flow {
        repeat(4) { index ->
            delay(100)
            println("Emitting B${index}")
            emit("B${index}")
        }
    }

    println("===== zip 연산자 =====")
    flowA.zip(flowB) { a, b -> "$a $b" }
        .collect { println("Zipped: $it") }

    println("===== combine 연산자 =====")
    flowA.combine(flowB) { a, b -> "$a $b" }
        .collect { println("Combined: $it") }
}