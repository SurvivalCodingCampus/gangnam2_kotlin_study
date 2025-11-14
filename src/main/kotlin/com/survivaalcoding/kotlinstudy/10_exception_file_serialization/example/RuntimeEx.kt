package com.survivaalcoding.kotlinstudy.`10_exception_file_serialization`.example

fun main() {
    val numString = "10.5"

    try {
        val num = numString.toInt()
        println(num)
    } catch (e: NumberFormatException) {
        println(0)
    }
}