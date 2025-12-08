package com.survivalcoding.kotlinstudy.`19_flow`.practice

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce

class DebounceFlowExample(
    val flow: Flow<String>
) {
    @OptIn(FlowPreview::class)
    fun getDebouncedFlow(): Flow<String> {
        return flow.debounce(300) // 300ms 대기
    }

    @OptIn(FlowPreview::class)
    suspend fun debounce300Operator() {
        getDebouncedFlow().collect { println("Debounced: $it") }
    }
}