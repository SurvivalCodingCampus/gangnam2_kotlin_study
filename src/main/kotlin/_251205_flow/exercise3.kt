@file:OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)

package _251205_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {

    val ioFlow = flow {
        emit("로딩중")
    }.flowOn(Dispatchers.IO)

    val defaultFlow = flow {
        emit("입력1")
        delay(100)
        emit("입력2")
        delay(400)
        emit("입력3")
        delay(200)
        emit("입력4")
        //expect = 2,4
    }.debounce(300).flowOn(Dispatchers.Default)
    val flows = flowOf(ioFlow,defaultFlow).flattenConcat()
    runBlocking {
        flows.collect {
            println(it)
        }
    }

}