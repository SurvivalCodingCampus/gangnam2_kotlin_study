package com.survival.kotlinstudy.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


fun dispatcherFlow() = flow {
    emit("데이터 로딩 중")
}.flowOn(Dispatchers.IO)

fun debounceFlow(list: List<String>) = flow {

    list.forEach { text ->
        emit(text)
        delay(100)
    }
}.debounce(300)