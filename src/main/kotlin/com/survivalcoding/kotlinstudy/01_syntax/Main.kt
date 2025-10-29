package com.survivalcoding.kotlinstudy.`01_syntax`

fun main() {
    val a = 1
    val b = 2

    val result = if (a > b) a else b
    println(result)

    val ddd = when (a) {
        1 -> 10
        2 -> 20
        else -> 30
    }

    for (i in 0..9) {
        println(i)
    }

    sum(a = 10, b = 20)
    sum(b = 20, a = 10)

    var name: String = "200"

    var name2: String? = "10"
    name2 = null

    if (name2 != null) {
        println(name2.toInt())
    } else {
        println("null")
    }

}

fun sum(a: Int, b: Int = 10): Unit {
    println(a + b)
    println("sum of $a and $b is ${a + b}")
}