package com.survivalcoding.kotlinstudy.`01_syntax`

// 컴파일 타임 상수: 실행 전 메모리에 올라가
const val PI = 3.14
const val MAX = 10

// 런타임 상수
val PI2 = 3.14
var x = 0 // main 에서 접근 불가

fun main () {
    println("Hello World")

    readln()
    // 상수
    val x = 5 // 타입 추론
    val s = "헬로"
    // val 3 // complie error

    val z: Long = x.toLong()

    // 변수
    var y = 5
    y++

    val a = 1
    val b = 2

    // if expression 식
    val result = println(if (a > b) a else b)
    println(result)

    val ddd = when(a) {
        1-> 10
        2 -> 20
        else -> 30
    }

    val list : List<Int> = (1..4).toList()

    repeat(10) {
        println()
    }

    for (i in 0..9) {
        println(i)
    }

    // named arguments
    sum(10,20)
    sum(a= 10, b=20)
    sum(b=20, a=10)

    var name: String = "홍길동"
    //name = null

    var name2: String? = "홍길동"
    name2 = null


}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2 (a: Int, b: Int) = a + b

// 리턴이 없는 경우
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}



fun incrementX() {
    x += 1
}

// x = 0; PI = 3.14
// incrementX()
// x = 1; PI = 3.14
