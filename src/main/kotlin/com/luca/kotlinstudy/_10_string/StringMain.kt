package com.luca.kotlinstudy._10_string

import kotlin.system.measureTimeMillis

fun main() {
    var name = "홍길동" // 새로운 인스턴스 생성

    name = "한석봉" // 새로운 인스턴스 생성

    val builder = StringBuilder(name)
    var time1 = measureTimeMillis {
        repeat(100) {
            builder.append("!")
        }
    }
    println(time1)

    val time2 = measureTimeMillis {

        repeat(100) {
            name += "!" // 한석봉! 역시 새로운 인스턴스 생성 스트링은 한 번 만들어지면 변경이 안된다.
        }
    }
    println(time2)

}