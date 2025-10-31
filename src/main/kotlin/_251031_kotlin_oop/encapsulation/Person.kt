package _251031_kotlin_oop.encapsulation

import java.time.LocalDate

class Person(
    val name: String,
    val birthYear: Int,

    ) {
    val age = LocalDate.now().year - birthYear
}