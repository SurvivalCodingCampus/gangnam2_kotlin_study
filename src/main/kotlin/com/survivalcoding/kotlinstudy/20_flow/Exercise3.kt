package com.survivalcoding.kotlinstudy.`20_flow`

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


// Dispatchers.IO에서 동작하는 Flow
fun loadingFlow(): Flow<String> = flow {
    println("Thread: ${Thread.currentThread().name}") // DefaultDispatcher-worker-2
    emit("데이터 로딩 중")
}.flowOn(Dispatchers.IO)

// Flow에 flowOn(Dispatchers.Default)를 적용하여 스레드 변경
fun changedFlow(loadingFlow: Flow<String>): Flow<String> =
    loadingFlow
        .map {
            println("Thread: ${Thread.currentThread().name}") // DefaultDispatcher-worker-1
            "Changing Thread : $it"
        }
        .flowOn(Dispatchers.Default)

// 키보드 입력(예: 5개의 문자열을 아주 짧은 간격으로 순차 방출)을 가정하여 Flow
fun keyboardInputFlow(inputs: List<String>): Flow<String> = flow {
    for (i in inputs) {
        delay(100)
        emit(i)
    }
}

// Flow에 debounce(300)을 적용하여, 입력이 300ms 동안 멈췄을 때만 최종 값을 방출하도록 처리하고 결과를 출력
@OptIn(FlowPreview::class)
fun debounceKeyboardFlow(keyboardFlow: Flow<String>): Flow<String> =
    keyboardFlow.debounce(300)


fun main() = runBlocking {
    println("Dispatcher 변경")

    changedFlow(loadingFlow())
        .collect {
            println("Thread: ${Thread.currentThread().name}") // main
            println(it)
        }

    println("\n 키보드 입력 연타 방지(debounce)")

    val keyboardFlow = keyboardInputFlow(listOf("qwer", "asdf", "zxcv", "wewrt", "sdfg"))

    debounceKeyboardFlow(keyboardFlow)
        .collect { println("최종값: $it") }
}

