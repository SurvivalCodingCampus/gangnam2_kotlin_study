package com.ezlevup.my.day251111

data class Person(
    val name: String,
    val age: Int,
)

fun main() {
    val person1 = Person("kim", 10)
    val person2 = Person("lee", 20)

    println(person1 === person2) // false

    val person3 = person1.copy()
    println(person1 === person3) // false
}
