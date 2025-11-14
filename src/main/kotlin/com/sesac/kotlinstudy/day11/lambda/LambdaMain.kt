package com.sesac.kotlinstudy.day11.lambda

import kotlin.math.max

fun main() {
    repeat(3, { println(it) })
    repeat(3) { println(it) }

    val items = listOf(1, 2, 3, 4, 5)
    items.forEach(::myFunction)

    println(items.reduce { acc, i -> max(acc, i) })
    println(items.any { it % 2 == 0 })
}

fun myFunction(i: Int): Unit {
    println(i)
}
