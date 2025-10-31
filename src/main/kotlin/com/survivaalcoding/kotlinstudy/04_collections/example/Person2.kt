package com.survivaalcoding.kotlinstudy.`04_collections`.example

import java.time.LocalDate

class Person2(val name: String, val birthYear: Int) {
    val age: Int
        get() = LocalDate.now().year - this.birthYear
}