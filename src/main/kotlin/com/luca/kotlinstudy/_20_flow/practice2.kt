package com.luca.kotlinstudy._20_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

// A: "A1", "A2", "A3" 을 300ms 간격으로 방출하는 Flow
fun flowA(): Flow<String> = flow {
    val items = listOf("A1", "A2", "A3")
    for (item in items) {
        delay(300L)
        emit(item)
    }
}

// B: "B1", "B2", "B3", "B4" 를 100ms 간격으로 방출하는 Flow
fun flowB(): Flow<String> = flow {
    val items = listOf("B1", "B2", "B3", "B4")
    for (item in items) {
        delay(100L)
        emit(item)
    }
}

fun main() = runBlocking {
    // zip
    flowA()
        .zip(flowB()) { a, b ->
            "$a + $b"
        }
        .collect {
            println("zip: $it")
        }

    // combine
    flowA()
        .combine(flowB()) { a, b ->
            "$a + $b"
        }
        .collect {
            println("combine: $it")
        }
}
