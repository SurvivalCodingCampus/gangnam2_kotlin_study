package com.sesac.kotlinstudy.day01_syntax

const val PI = 3.14 // 컴파일타임 상수
val PI2 = 3.14 // 런타임 상수
var x = 0

fun main() {
    println("Hello World")

    readln()

    // 상수
    val x = 5 // 타입 추론
    val s: String = "Hello"
//    x = 4 // compile error

    val z: Long = x.toLong()

    // 변수
    var y = 5
    y++

    y = 10L.toInt()

    val a = 1
    val b = 2

    // if expression 식
    val result = if (a > b) a else b

    println(result)

    val result2 = when (a) {
        1 -> 10
        2 -> 20
        else -> 30
    }

    val list: List<Int> = (1..4).toList()

    for (number in 1..5) {
        print(number)
    }

    repeat(10) {
        print(it)
    }

    sum(10, 20)
    // named arguments
    sum(a = 10, b = 20)
    sum(b = 20, a = 10)

    sum4(10)
    sum4(a = 10)

    var name: String = "홍길동"
//    name = null // compile error
    println(name.length)

    // nullable
    var name2: String? = "홍길동"
    name2 = null
    println(name2?.length)

    // null 이 아님을 보증 (절대 금지)
    name = name2!!
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun sum3(a: Int, b: Int): Unit {
    println(a + b)
}

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun sum4(a: Int, b: Int = 10): Int {
    return a + b
}
