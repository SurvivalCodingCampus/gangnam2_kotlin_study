package com.ezlevup.my.day251118

import kotlinx.coroutines.delay

class AsyncMain {
}

fun main() {
    // println(Thread.currentThread())

}


suspend fun myAsyncFunction() {
    delay(2000)
    println("hello async")
}