package com.ezlevup.my.day251118.exercise

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds


interface Chirpable {
    fun chirp()
}

class Bird(
    val chirpText: String,
    val chirpIntervalSec: Int
) : Chirpable {
    var chirpCount: Int = 0 // 몇 번 울었어.
        private set

    override fun chirp() {
        chirpCount++
        println("$chirpText / $chirpIntervalSec sec / $chirpCount 번")
    }
}

object BirdConfig {
    const val MAX_DURATION_SEC = 10
    const val ONE_SECOND_MILLIS = 1_000L
}

fun main(): Unit = runBlocking {
    val bird1 = Bird("꾸욱", 1)
    val bird2 = Bird("까악", 2)
    val bird3 = Bird("짹짹", 3)

    val birds = listOf<Bird>(bird1, bird2, bird3)

    val jobs = birds.map { bird ->
        launch {
            while (true) {
                bird.chirp()
                //delay(bird.chirpIntervalSec * BirdConfig.ONE_SECOND_MILLIS)
                delay(bird.chirpIntervalSec.seconds)
            }
        }
    }

    val maxSec: Int = BirdConfig.MAX_DURATION_SEC
    var currentSec: Int = 0 // 현재 진행한 초
    val timerJob = launch {
        while (currentSec < maxSec) {
            currentSec++
            delay(BirdConfig.ONE_SECOND_MILLIS)
            println("$currentSec sec")
        }

        jobs.forEach { job -> job.cancel() }
    }

    timerJob.join()
}


