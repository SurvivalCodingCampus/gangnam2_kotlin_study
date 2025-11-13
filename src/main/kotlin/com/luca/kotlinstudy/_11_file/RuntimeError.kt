package com.luca.kotlinstudy._11_file

class RuntimeError(i: Int)

fun safeToInt(numString: String): Int {
    return try {
        numString.toInt()
    } catch (e: Exception) {
        0
    }
}
