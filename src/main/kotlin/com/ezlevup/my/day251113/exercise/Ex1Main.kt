package com.ezlevup.my.day251113.exercise

class Ex1 {
    companion object {
        fun toIntOrZero(s: String): Int {
            try {
                return s.toInt()
            } catch (e: NumberFormatException) {
                println("NumberFormatException")
            } catch (e: Exception) {
                println("Exception")
            }
            return 0
        }
    }
}


// val String.toIntOrZero: Int
//    get() = toIntOrNull() ?: 0

public fun String.toIntOrZero(): Int = toIntOrNull() ?: 0

fun main() {
    val numString: String = "10.8"

    val num: Int = Ex1.toIntOrZero(numString)
    println(num)

    // val num = numString.toIntOrNull()
    // println(num)

    // val num = numString.toIntOrZero
    // println(num)

    // val num = numString.toIntOrZero()
    // println(num)

}