package com.survivaalcoding.kotlinstudy.`18_flow`.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class Example3 {
    companion object {
        suspend fun dispatcherFlow(): Flow<String> = withContext(Dispatchers.IO) {
            flow {
                emit("데이터 로딩 중")
            }.flowOn(Dispatchers.Default)
        }

        fun getKeyboardInputFlow(inputs: List<String>): Flow<String> = flow {
            for (input in inputs) {
                emit(input)
                delay(100)
            }
        }

        @OptIn(FlowPreview::class)
        fun getDebouncedFlow(inputs: List<String>, debounce: Long): Flow<String> = getKeyboardInputFlow(inputs)
            .debounce(debounce)
    }
}