package com.neouul.sesac.`09-exception`

fun main() {
    val numString = "10.5"

//    val num: Int = numString.toInt()
//    println(num)

    try {
        val num: Int = numString.toInt()
        println(num)
    } catch (e: NumberFormatException) {
        val num = 0
        println(num)
    }
}