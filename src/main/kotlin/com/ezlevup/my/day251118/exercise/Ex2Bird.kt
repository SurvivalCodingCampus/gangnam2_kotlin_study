package com.ezlevup.my.day251118.exercise

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


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

fun main() = runBlocking {
    val bird1 = Bird("꾸욱", 1)
    val bird2 = Bird("까악", 2)
    val bird3 = Bird("짹짹", 3)

    val birds = listOf<Bird>(bird1, bird2, bird3)

    birds.forEach { bird ->
        launch {
            repeat(4) {
                bird.chirp()
                delay(bird.chirpIntervalSec * 1000L)
            }
        }
    }

    return@runBlocking
}


