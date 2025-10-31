package com.sesac.practice.day04

import java.time.LocalDate

class Person(
    val name: String,
    val birthYear: Int,
    private val now: LocalDate = LocalDate.now(),
) {
    val age: Int
        get() {
            return now.year - birthYear
        }
}
