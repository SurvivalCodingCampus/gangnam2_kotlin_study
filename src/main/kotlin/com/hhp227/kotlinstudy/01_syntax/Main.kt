package com.hhp227.kotlinstudy.`01_syntax`

const val PI = 3.14

fun main() {
    println("Hello World")
    // 상수
    val x = 5
    //x = 4 // comfile error

    // 변수
    var y = 5
    y = 10L.toInt()

    val a = 1
    val b = 2

    // if expression
    val result = if (a > b) a else b
    println(result)

    val add = when (a) {
        1 -> 10
        2 -> 20
        else -> 30
    }

    sum(10, 20)
    // named argument
    sum(a = 10, b = 20)
    sum(10)
    sum(a = 10)

    var name: String = "홍길동"
    //name = null non null
    var name2: String? = "홍길동"
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

fun sum(a: Int, b: Int = 10) {
    println("sum of $a and $b is ${a + b}")
}