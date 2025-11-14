package com.hhp227.kotlinstudy.`11_lambda`

fun main() {
    repeat(3) {
        print(it)
    }

    val items = listOf(1, 2, 3, 4, 5)

    items.forEach(::myFunction)

    items.sortedWith { a, b -> a.compareTo(b) }

    items.reduce { acc, i -> acc + i }
}

fun myFunction(i: Int) {
    print(i)
}