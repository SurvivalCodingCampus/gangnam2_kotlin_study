package _251205_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() {

    val flowA = flow {
        for (i in 1..3) {
            emit("A$i")
            delay(300L)
        }
    }
    val flowB = flow {
        for (i in 1..4) {
            emit("B$i")
            delay(100L)
        }
    }

    val jobZip = runBlocking {
        flowA.zip(flowB) { a, b -> "$a$b" }
            .collect {
                println("Zipped: $it")
            }
    }

    val jobCombine = runBlocking {
        flowA.combine(flowB) { a, b -> "$a$b" }.collect {
            println("Combined: $it")

        }
    }


}