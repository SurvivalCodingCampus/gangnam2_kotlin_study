package com.survivalcoding.kotlinstudy.`20_flow`

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

// flow A : 300ms 간격으로 "A1", "A2", "A3"
fun getFlowA(listA: List<String>) = flow {
    for (a in listA) {
        delay(300)
        emit(a)
    }
}

// flow B : 100ms 간격으로 B1", "B2", "B3", "B4"
fun getFlowB(listB: List<String>) = flow {
    for (b in listB) {
        delay(100)
        emit(b)
    }
}


fun getZip(flowA: Flow<String>, flowB: Flow<String>) =
    flowA.zip(flowB) { a, b -> "$a - $b" }

fun getCombine(flowA: Flow<String>, flowB: Flow<String>) =
    flowA.combine(flowB) { a, b -> "$a - $b" }

fun main() = runBlocking {
    val flowA = getFlowA(listOf("A1", "A2", "A3"))
    val flowB = getFlowB(listOf("B1", "B2", "B3", "B4"))

    /**
     * ZIP
     *
     * A1 - B1
     * A2 - B2
     * A3 - B3
     *
     * B4는 매칭 상대가 없어서 버려짐
     */
    println("ZIP")
    getZip(flowA, flowB)
        .collect { println(it) }

    /**
     * COMBINE
     *
     * A1 - B2
     * A1 - B3
     * A1 - B4
     * A2 - B4
     * A3 - B4
     *
     * 새 값 발생 시마다 최신 조합을 사용
     */
    println("COMBINE")
    getCombine(flowA, flowB)
        .collect { println(it) }
}