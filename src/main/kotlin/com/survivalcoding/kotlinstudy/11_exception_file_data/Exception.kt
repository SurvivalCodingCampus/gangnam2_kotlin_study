package com.survivalcoding.kotlinstudy.`11_exception_file_data`


fun main() {
    val numString = "10.5"
    val num = StringToInt(numString)
    println(num)
}

fun StringToInt(str: String): Int {
    return try {
        str.toInt() // 숫자로 변환
    }   // 예외 처리
    catch (e: NumberFormatException) {
        println("숫자형 형태 변환 오류: ${e.message}")
        0
    } catch (e: IllegalArgumentException) {
        println("잘못된 인자 오류: ${e.message}")
        0
    } catch (e: Exception) {
        println("예상치 못한 오류: ${e.message}")
        0
    }
}

