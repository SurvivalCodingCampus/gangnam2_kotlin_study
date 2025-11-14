package com.survivalcoding.kotlinstudy.`11_lamda`

import kotlin.math.max

fun main() {
    repeat(3) {
        println(it)
    }

    val items: List<Int> = listOf(1, 2, 3, 4, 5)

    items.forEach(::myFunction)

    items.sortedWith { a, b -> a.compareTo(b) }


    println(items.reduce(::max))
}

fun myFunction(i: Int): Unit {
    println(i)
}