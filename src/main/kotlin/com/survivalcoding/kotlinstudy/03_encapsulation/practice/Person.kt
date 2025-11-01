package com.survivalcoding.kotlinstudy.`03_encapsulation`.practice

import java.time.LocalDate

class Person(
    val name: String,   // 이름
    val birthYear: Int, // 태어난 해
) {
    // 올해 년도
    private val currentYear: Int = LocalDate.now().year

    // 나이
    val age: Int
        get() = currentYear - birthYear
}