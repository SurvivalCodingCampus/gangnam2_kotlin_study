package com.survivaalcoding.kotlinstudy.`01_syntax`

const val PI = 3.14

fun main() {
    println("Hello World")

    val x = 5
    val z: Long = x.toLong()

    sum(a = 10, b = 20)
    sum(b = 10, a = 20)
}

//fun sum(a: Int, b: Int): Int {
//    return a + b
//}

//fun sum(a: Int, b: Int) = a + b

fun sum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}