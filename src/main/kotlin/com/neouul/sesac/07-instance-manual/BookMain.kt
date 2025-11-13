package com.neouul.sesac.`07-instance-manual`

import java.time.LocalDateTime

fun main() {
    val b1 = Book("1", "sk", LocalDateTime.of(2025, 11, 1, 0, 0, 0))
    val b2 = Book("1", "sk", LocalDateTime.of(2025, 11, 3, 0, 0, 0))
    val b3 = Book("1", "sk", LocalDateTime.of(2025, 11, 7, 0, 0, 0))

    val b4 = Book("1", "sk", LocalDateTime.of(2025, 11, 1, 9, 9, 29))

    val list = listOf<Book>(b1, b2, b3)
    val sortedList = list.sorted()
    println(sortedList)

    println(b1 == b4)

    val set = mutableSetOf<Book>()
    set.add(b1)
    println(set)
    set.remove(b4)
    println(set.size)
}