package com.survivaalcoding.kotlinstudy.`18_flow`.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val flow = flow {
            (1..5).forEach { i ->
                delay(100)
                emit(i)
            }
        }

        flow.filter { it % 2 == 0 }
            .map { it * 10 }
            .collect { value ->
                println("Collected: $value")
            }
    }
}
