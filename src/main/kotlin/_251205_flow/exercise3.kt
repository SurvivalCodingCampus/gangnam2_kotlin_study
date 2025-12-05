@file:OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)

package _251205_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*


val ioFlow = flow {
    emit("데이터 로딩 중")
}.flowOn(Dispatchers.IO)

val defaultFlow = flow {
    for (i in 1..5) {
        emit("${i}번째 키보드 입력")
    }
    //expect = 2,4
}.debounce(300).flowOn(Dispatchers.Default)

val flows = flowOf(ioFlow, defaultFlow).flattenConcat()


