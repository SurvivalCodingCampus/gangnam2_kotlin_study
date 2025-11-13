package com.survivalcoding.kotlinstudy.`11_exception_file_data`


fun main() {
    val numString = "10.5"

    val num: Int = try {
        numString.toInt()
    } catch (e: NumberFormatException) {
        println("NumberFormatException : ${e.message} ")
        0
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }

    println(num)

}

