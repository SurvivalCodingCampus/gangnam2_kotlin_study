package com.survivaalcoding.kotlinstudy.`03_encapsulation`.example

import java.time.LocalDate

class Person(val name: String, val birthYear: Int) {
    val age: Int
        get() = LocalDate.now().year - this.birthYear
}