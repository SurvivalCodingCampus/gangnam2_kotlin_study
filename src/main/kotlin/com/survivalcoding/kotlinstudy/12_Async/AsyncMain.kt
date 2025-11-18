package com.survivalcoding.kotlinstudy.`12_Async`

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// 코루틴 기본 동작 : 순차 실행
fun main() = runBlocking {
    // Main Thread
    println(Thread.currentThread())

    // 1초간 블록
    println("Main Thread 1초 대기 : ")
    Thread.sleep(1000)

    // 새로운 쓰레드 생성, kotlin 에서는 쓸 일 없음
    Thread {
        // 오래 걸리는 코드
        println(Thread.currentThread())
    }.start()

    // 1초 실행
    myAsyncFunction()

    val person1 = Person()
    val person2 = Person()

    val person3 = Person2
    val person4 = Person2

    println("끝!!!!!!!!!")
}

// 비동기 함수
suspend fun myAsyncFunction() {
    println("myAsyncFunction 1초 대기 : ")
    delay(1000)
    println("Hello Async")
}

// 인스턴스를 런타임 생성하기 위한
class Person

// 1개만 (싱글턴)
object Person2