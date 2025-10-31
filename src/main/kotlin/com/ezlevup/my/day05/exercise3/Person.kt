package com.ezlevup.my.day05.exercise3

class Person(
    val name: String
) {}

fun main() {
    val persons = mutableListOf<Person>()
    persons.add(Person(name = "홍길동"))
    persons.add(Person(name = "한석봉"))

    persons.forEach { person -> println(person.name) }
}
