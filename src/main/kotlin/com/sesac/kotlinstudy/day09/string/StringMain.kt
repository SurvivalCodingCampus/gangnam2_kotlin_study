package com.sesac.kotlinstudy.day09.string

import kotlin.system.measureTimeMillis

fun main() {
    val string = "Hello"
    println(string.substring(0, 2))
    println(string.lowercase())

    var name = "홍길동" // 새로운 인스턴스 생성
    name = "한석봉" // 새로운 인스턴스 생성
    println(name)

    var time = measureTimeMillis {
        repeat(10000) {
            name += "!" // 새로운 인스턴스 생성
        }
    }
    println(time)

    val builder = StringBuilder(name)
    time = measureTimeMillis {
        repeat(10000) {
            builder.append("!")
        }
    }
    println(time)

    val str1 = "hello"
    val str2 = "hello"
    println(str1 === str2)

    val str3 = String("hello".toCharArray())
    println(str1 === str3)

    val str4 = "hel" + "lo"
    println(str1 === str4)

    val str5 = "hel" + getLo()
    println(str1 === str5)

    println(str1 === str6)
    println(str1 === "hel" + str7)

    println(str1 === Hello.STR)
    println(str1 === "hel" + Hello.LO)
    println(str1 === "hel" + Hello.getLo())
}

fun getLo(): String = "lo"

const val str6 = "hello"
const val str7 = "lo"

class Hello {
    companion object {
        const val STR = "hello"
        const val LO = "lo"
        fun getLo(): String = "lo"
    }
}
