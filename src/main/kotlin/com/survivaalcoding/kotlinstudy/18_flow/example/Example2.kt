package com.survivaalcoding.kotlinstudy.`18_flow`.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip

class Example2 {
    companion object {
        fun getFlowA(list: List<String>): Flow<String> = flow {
            list.forEach {
                delay(300)
                emit(it)
            }
        }

        fun getFlowB(list: List<String>): Flow<String> = flow {
            list.forEach {
                delay(100)
                emit(it)
            }
        }

        fun getFlowZip(flowA: Flow<String>, flowB: Flow<String>): Flow<String> =
            flowA.zip(flowB) { a, b -> "$a$b" }

        fun getFlowCombine(flowA: Flow<String>, flowB: Flow<String>): Flow<String> =
            flowA.combine(flowB) { a, b -> "$a$b" }
    }
}
