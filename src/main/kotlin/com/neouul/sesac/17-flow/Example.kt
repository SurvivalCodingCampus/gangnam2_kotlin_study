package com.neouul.sesac.`17-flow`

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

@OptIn(FlowPreview::class)
fun main() = runBlocking {
    // 1. 기본 Flow 생성과 수집
    println("\n1. 기본 Flow")
    val basicFlow = flow {
        for (i in 1..3) {
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

    // 4. Flow 합치기
    // 4-1) Zip 연산자
    val flow1 = flowOf(1, 2, 3)
    val flow2 = flowOf("A", "B", "C")

    flow1.zip(flow2) { number, letter ->
        "$number - $letter"
    }.collect { println("Zipped: $it") }
    // 출력: 1 - A, 2 - B, 3 - C


    // 4-2) Combine 연산자
    val flow3 = flowOf(1, 2, 3).onEach { delay(100) }   // 0.1초 대기
    val flow4 = flowOf("A", "B", "C").onEach { delay(200) } // 0.2초 대기

    flow3.combine(flow4) { number, letter ->
        "$number - $letter"
    }.collect { println("Combined: $it") }
    // 출력: 1 - A, 2 - A, 2 - B, 3 - B, 3 - C


    // 9. debounce
    val flow9 = flow{
        emit("A")
        delay(100)
        emit("B")
        delay(90)
        emit("C")
        delay(110)
        emit("D")
        delay(80)
        emit("E")
    }.debounce(100)
        .collect { println("Debounced: $it") }
    // 출력: A, C, E
}