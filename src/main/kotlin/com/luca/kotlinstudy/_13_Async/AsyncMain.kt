package com.luca.kotlinstudy._13_Async

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 코루틴 기본 동작 : 순차 실행
fun main() = runBlocking {
    println(Thread.currentThread())
    // 1초간 블럭 = 멈춘다
    Thread.sleep(1000)
//    Thread(object : Runnable {
//        override fun run() {
//            //오래 걸리는 코드
//        }
//    }).start()
    // 새로운 쓰레드 생성, 코틀린에서는 쓸 일 없음
    Thread {
        println(Thread.currentThread())
    }.start()

    // 1초 실행
    myAsyncFunction()

    val pesron1 = Person()
    val pesron2 = Person2

    println("끝!")
}

// 비동기 함수
suspend fun myAsyncFunction() {
    delay(2000)
    println("Hello Async")
}
// 인스턴스를 런타임에 생성하기 위한 목적
class Person

// 한 개만 가지고 있겠다는 것 (싱글턴)
object Person2