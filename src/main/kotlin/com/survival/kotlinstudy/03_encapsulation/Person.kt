package com.survival.kotlinstudy.`03_encapsulation`

import java.time.LocalDate

class Person(
    val name: String,
    val birthYear: Int,
) {
    val age: Int
        get() = LocalDate.now().year - birthYear
}