package com.survival.kotlinstudy.`09_string`

import kotlin.system.measureTimeMillis

fun main() {
    var name: String = "홍길동"

    name = "한석봉"

    val builder = StringBuilder(name)
    var time = measureTimeMillis {
        repeat(1000000) {
            builder.append("!")
        }
    }
    println(time)

    val str = "hello"
    val str2 = "hello"

    println(str === str2)

    println("------------")

    val str3 = String("hello".toCharArray())

    println(str === str3)

    val str4 = "hel" + "lo"
    println(str === str4)

    fun getlo(): String = "lo"
    val str5 = "hel" + getlo()
    println(str === str5)
}