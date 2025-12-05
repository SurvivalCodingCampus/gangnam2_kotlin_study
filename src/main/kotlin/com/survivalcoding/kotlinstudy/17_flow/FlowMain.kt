package com.survivalcoding.kotlinstudy.`17_flow`

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Cold
    val basicFlow: Flow<Int> = flow {
        delay(500)
        emit(1)
        delay(500)
        emit(2)
        delay(500)
        emit(3)
    }

    val intFlow: Flow<Int> = flowOf(1, 2, 3)

    intFlow.filter { it > 1 }
        .map { "$it !!" }
        .collect {
        println(it)
    }

    val stateFlow: MutableStateFlow<Int> = MutableStateFlow(0)

    val job = launch {
        stateFlow.collect {
            // UI 업데이트
            println(it)
        }
    }

    // 데이터가 변경
    delay(1000)
    stateFlow.value = 1
    delay(1000)
    stateFlow.value = 2


//    basicFlow.collect {
//        println(it)
//    }

    println("======================")

    flow {
        emit("A")
        delay(100)
        emit("B")
        delay(90)
        emit("C")
        delay(110)
        emit("D")
    }.debounce(100)
        .collect {
            println(it)
        }
}