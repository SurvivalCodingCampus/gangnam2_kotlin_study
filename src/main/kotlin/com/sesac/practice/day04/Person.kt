package com.sesac.practice.day04

import java.time.LocalDate

class Person(
    val name: String,
    val birthYear: Int,
    now: LocalDate = LocalDate.now(),
) {
    private val _now = now

    val age: Int
        get() {
            return _now.year - birthYear
        }
}
