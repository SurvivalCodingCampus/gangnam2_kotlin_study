package _251205_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


val flow = flow {
    for (i in 1..5) {
        emit(i)
        delay(100L)
    }
}.filter { it % 2 == 0 }.map { it * 10 }

val job = runBlocking {
    flow.collect {
        println(it)
    }

}

