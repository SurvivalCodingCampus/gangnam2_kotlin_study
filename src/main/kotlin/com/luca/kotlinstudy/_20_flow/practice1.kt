package com.luca.kotlinstudy._20_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

// 1부터 5까지 숫자를 100ms 간격으로 방출하는 Flow
fun numberFlow(): Flow<Int> = flow {
    var number = 1
    while (number <= 5) {
        delay(100L)
        emit(number++)
    }
}

fun main() = runBlocking {
    numberFlow()
        .filter { it % 2 == 0 }
        .map { it * 10 }
        .collect { println(it) }
}
