package com.survival.kotlinstudy.file

fun numberFormat() {
    val numString = "10.5"
    val num: Int = try {
        numString.toInt()
    } catch (e: Exception) {
        0
    }
    println(num)
}