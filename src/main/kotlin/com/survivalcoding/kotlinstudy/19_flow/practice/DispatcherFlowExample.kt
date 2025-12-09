package com.survivalcoding.kotlinstudy.`19_flow`.practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class DispatcherFlowExample(
    val flow: Flow<String>
) {
    fun getFlowOnDefault(): Flow<String> {
        return flow.flowOn(Dispatchers.Default)
    }

    suspend fun dispatcherDefaultOperator() {
        getFlowOnDefault().collect { println("DefaultDispatchers: $it") }
    }
}
