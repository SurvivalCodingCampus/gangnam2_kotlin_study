package com.survivalcoding.kotlinstudy.`11_file`.practice

/*
1번.

작성한 코드를 수정하여, try-catch() 문을 사용하여 예외처리를 하시오.
예외처리에는 다음의 처리를 수행하시오.

예외가 발생하면 0으로 처리
*/

fun main() {
    val numString = "10.5"

    val num: Int = try {
        numString.toInt()
    } catch (e: Exception){
        0
    }
}