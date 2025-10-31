package com.luca.kotlinstudy._04_collection

import java.time.LocalDate

class Person(
    val name: String,
    val birthYear: Int,
) {
    val age: Int
        get() = LocalDate.now().year - birthYear

}

fun main() {
    val p1 = Person("루카", 1996)
    println("${p1.name}의 나이는 ${p1.age +1 }세입니다.")
}
