package com.survivaalcoding.kotlinstudy.`07_polymorphism`.example

fun main() {
    val obj: X = A()
    obj.a()
//    println(obj.b())  // compile error
//    println(obj.c())  // compile error
    println()

    val y1: Y = A()
    val y2: Y = B()
    y1.a() // Aa
    y2.a() // Ba
}