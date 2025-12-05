package com.neouul.sesac.`17-flow`

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // 1. 기본 Flow 생성과 수집
    println("\n1. 기본 Flow")
    val basicFlow = flow {
        for (i in 1..3){
            delay(100)
            println("Emitting $i")
            emit(i)
        }
    }

    basicFlow.collect { value ->
        println("Collected: $value")
    }

//    basicFlow.shareIn(
//        scope = TODO(),
//        started = TODO(),
//        replay = TODO()
//    )
}