package com.neouul.sesac.`17-flow`

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@OptIn(FlowPreview::class)
fun main() = runBlocking {
    // 연습문제 3
    val flow1 = withContext(Dispatchers.IO) {
        flow{
            emit("데이터 로딩 중")
        }.flowOn(Dispatchers.Default)
            .collect {
                println(it)
            }
    }

    val flow2 = flow{
        while (true){
            emit(readln())
        }
    }.debounce(300)
        .collect { println("Debounced: $it") }
}