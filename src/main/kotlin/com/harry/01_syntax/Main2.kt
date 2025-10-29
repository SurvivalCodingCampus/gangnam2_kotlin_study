package com.harry.`01_syntax`

val PI = 3.14
var z = 1

fun main() {
    println("두 번째 메인 함수")
    val x: Int = 5 // 타입 추론
    val s = "헬로"
    var y = 1

    val result = if (x > y) x else y
    println(result)

    val str = when (s) {
        "헬로" -> "참"
        else -> "거짓"
    }
    println(str)

    val list: List<Int> = (1..5).toList()

    repeat(10) {
        // 10 바퀴 돌릴 때
    }

    for (i in 0..9) {
        print(i)
    }

    sum(a = x, b = y)

    var name : String = "200"
    println(name.toInt())

    var name2 : String? = "10"

    println(name2?.toInt())

    name = name2 ?: "2"
    name = name2!! // 사용 금지
}

fun sum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}