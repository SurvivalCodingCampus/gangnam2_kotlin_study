package com.neouul.sesac.`04-encapsulation`

import java.time.LocalDate

class Person(
    val name: String,
    val birthYear: Int,
) {
    val age: Int
        get() = calculateAge()

    fun calculateAge(): Int {
        // java.time 패키지
        val recentYear = LocalDate.now().year
        return recentYear - birthYear
    }
}