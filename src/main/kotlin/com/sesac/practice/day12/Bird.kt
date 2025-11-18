package com.sesac.practice.day12

import kotlinx.coroutines.delay

class Bird(
    val sound: String,
    val delayTimeMillis: Long,
) {
    suspend fun cry(): String {
        delay(delayTimeMillis)

        return sound
    }
}
