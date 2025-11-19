package _251118_coroutine.exercise3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch {
        launch(Dispatchers.IO) {
            firstBird(startTime)
        }
        launch(Dispatchers.IO) {
            secondBird(startTime)
        }
        launch(Dispatchers.IO) {
            thirdBird(startTime)
        }
    }

    launch {
        delay(10000)
        job.cancel()
    }
}


suspend fun firstBird(startTime: Long) {
    while (true) {
        delay(1000L)
        val currentTime = System.currentTimeMillis()
        println("꾸우 ${currentTime - startTime}ms")
    }
}

suspend fun secondBird(startTime: Long) {
    while (true) {
        delay(2000L)
        val currentTime = System.currentTimeMillis()
        println("까악 ${currentTime - startTime}ms")
    }
}

suspend fun thirdBird(startTime: Long) {
    while (true) {
        delay(3000L)
        val currentTime = System.currentTimeMillis()
        println("짹짹 ${currentTime - startTime}ms")
    }
}
