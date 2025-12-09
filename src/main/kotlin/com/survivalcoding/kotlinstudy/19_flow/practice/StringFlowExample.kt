package com.survivalcoding.kotlinstudy.`19_flow`.practice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.zip

class StringFlowExample(
    val flow1: Flow<String>,
    val flow2: Flow<String>
) {
    fun getZippedFlow(): Flow<String> {
        return flow1.zip(flow2) { a, b -> "$a$b" }
    }

    fun getCombinedFlow(): Flow<String> {
        return flow1.combine(flow2) { a, b -> "$a$b" }
    }

    suspend fun zipOperator() {
        getZippedFlow().collect { println("Zipped: $it") }
    }

    suspend fun combineOperator() {
        getCombinedFlow().collect { println("Combined: $it") }
    }
}