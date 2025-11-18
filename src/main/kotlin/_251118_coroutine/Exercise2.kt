package _251118_coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val b1 = async(Dispatchers.IO) {
        repeat(4) {
            firstBird(startTime)
        }
    }
    val b2 = async(Dispatchers.IO) {
        repeat(4) {
            secondBird(startTime)
        }
    }
    val b3 = async(Dispatchers.IO) {
        repeat(4) {
            thirdBird(startTime)
        }
    }
    b1.await()
    b2.await()
    b3.await()
}


suspend fun firstBird(startTime: Long) {
    delay(1000L)
    val currentTime = System.currentTimeMillis()
    println("꾸우 ${currentTime - startTime}ms")
}

suspend fun secondBird(startTime: Long) {
    delay(2000L)
    val currentTime = System.currentTimeMillis()
    println("까악 ${currentTime - startTime}ms")
}

suspend fun thirdBird(startTime: Long) {
    delay(3000L)
    val currentTime = System.currentTimeMillis()
    println("짹짹 ${currentTime - startTime}ms")
}
