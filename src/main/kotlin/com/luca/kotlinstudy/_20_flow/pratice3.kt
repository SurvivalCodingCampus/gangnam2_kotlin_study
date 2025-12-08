package com.luca.kotlinstudy._20_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*


fun dispatcherFlow(): Flow<String> = flow {
    emit("데이터 로딩 중")
}.flowOn(Dispatchers.IO)

@OptIn(FlowPreview::class)
fun keyboardInputFlow(list: List<String>): Flow<String> =
    flow {
        for (text in list) {
            emit(text)
        }
    }.debounce(300)