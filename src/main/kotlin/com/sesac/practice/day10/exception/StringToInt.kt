package com.sesac.practice.day10.exception

class StringToInt {
    companion object {
        fun parse(numString: String): Int {
            return try {
                numString.toInt()
            } catch (_: NumberFormatException) {
                0
            }
        }
    }
}
