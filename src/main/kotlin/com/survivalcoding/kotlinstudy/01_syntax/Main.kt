package com.survivalcoding.kotlinstudy.`01_syntax`

import java.io.Console

// 컴파일타임 상수
const val PI = 3.14
const val MAX = 3.14

// 런타임 상수
val PI2 = 3.14
var x = 0

fun main() {
    println("Hello World")

    readln()

    // 상수
    val x: Int = 5       // 타입 추론
    val s = "헬로"

    val z: Long = x.toLong()

    // 변수
    var y = 5

    y = 10L.toInt()


    val a = 1
    val b = 2

    // if expression 식
    val result = if (a > b) a else b

    println(result)

    val ddd = when(a) {
        1 -> 10
        2 -> 20
        else -> 30
    }

    val list: List<Int> = (1..4).toList()

    repeat(10) {
        println()
    }

    for (i in 0..9) {
        println(i)
    }

    sum(10, 20)

    // named arguments
    sum(a = 10, b = 20)
    sum(b = 20, a = 10)

    sum(10)
    sum(a = 10)

    var name: String = "200"
    println(name.toInt())

    // String nullable
    var name2: String? = "10"
    name2 = null

    if (name2 != null) {
        println(name2.toInt())
    } else {
        println("null")
    }

    println(name2?.toInt())

    // null 이 아님을 보증 (절대 금지)
    name = name2!!

    name2 = name
}

fun sum(a: Int, b: Int = 10): Unit {
    println("sum of " + a + "and" + "b is " + (a + b))
    println("sum of $a and $b is ${a + b}")
}