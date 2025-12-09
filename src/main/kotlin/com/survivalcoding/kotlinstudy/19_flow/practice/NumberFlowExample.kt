package com.survivalcoding.kotlinstudy.`19_flow`.practice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

class NumberFlowExample(
    val flow: Flow<Int>
) {
    fun getProcessedFlow(): Flow<Int> {
        return flow
            .filter { it % 2 == 0 }
            .map { it * 10 }
    }

    suspend fun processEvenNumbers() {
        getProcessedFlow().collect {
            println("Number: $it")
        }
    }
}