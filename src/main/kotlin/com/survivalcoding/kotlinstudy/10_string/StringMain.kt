package com.survivalcoding.kotlinstudy.`10_string`

import kotlin.system.measureTimeMillis


fun main() {
    var name: String = "홍길동"    // 새로운 인스턴스 생성

    name = "한석봉"        // 새로운 인스턴스 생성

    val builder = StringBuilder(name)
    var time = measureTimeMillis {
        repeat(1000000) {
//            name += "!"
            builder.append("!")
            // name = name + "!"
        }
    }
    println(time)

    time = measureTimeMillis {
        repeat(1000000) {
            name += "!"
            // name = name + "!"
        }
    }
    println(time)
}