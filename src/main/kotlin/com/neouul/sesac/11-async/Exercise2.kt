package com.neouul.sesac.`11-async`

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(): kotlin.Unit = runBlocking {
    val time = measureTimeMillis {
        coroutineScope {
            launch {
                repeat(4) {
                    delay(1000L)
                    println("꾸우")
                }
            }

            launch {
                repeat(4) {
                    delay(2000L)
                    println("까악")
                }
            }

            launch {
                repeat(4) {
                    delay(3000L)
                    println("짹짹")
                }
            }
        }
    }
    println("$time ms")
}


