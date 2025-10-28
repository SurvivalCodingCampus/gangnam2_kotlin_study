package com.survival.kotlinstudy.`01_syntax`


// 컴파일타임 상수
const val PI = 3.14

//런타임 상수
val PI2 = 3.14

var x = 0

fun main() {
    println("Hello World")

//    val x = 5
//    x= 4 // compile error

    val x = 5 // 타입 추론
    val s = "헬로"

    //다형성
    val z: Long = x.toLong()
    var y = 5

    val a = 1
    val b = 2

    val result = if (a > b) a else b

    val ddd = when (a) {
        1 -> 10
        2 -> 20
        else -> 30
    }

    for (i in 0..9) {
        println(i)
    }

    repeat(10) {
        println(it)
    }

    sum(10, 20)

    //named arguments
    sum(a = 10, b = 20)
    sum(b = 20, a = 10)


    //Null Safety
    var name: String = "200"
    println(name.toInt())

    var name2: String? = "10"
    name2 = null

    if (name2 != null) {
        println(name2.toInt())
    }

    println(name2?.toInt())

    //null 이 아님을 보증(절대 금지)
    name = name2!!
}
//
//fun sum(a: Int, b: Int): Int {
//    return a + b
//}

//fun sum(a: Int, b: Int) = a + b

fun sum(a: Int, b: Int) { // : Unit 형태 인데 생략 가능
    println("sum of $a and $b is ${a + b}")
}

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

