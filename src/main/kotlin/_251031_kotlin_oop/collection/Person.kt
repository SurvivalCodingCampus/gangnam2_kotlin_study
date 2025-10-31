package _251031_kotlin_oop.collection

import java.time.LocalDate

class Person(
    val name: String,
    val birthYear: Int,

    ) {
    val age = LocalDate.now().year - birthYear

}