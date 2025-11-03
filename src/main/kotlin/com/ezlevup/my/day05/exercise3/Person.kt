package com.ezlevup.my.day05.exercise3

class Person(
    val name: String,
) {}

fun main() {
    val persons = mutableListOf<Person>()
    persons.add(Person(name = "홍길동"))
    persons.add(Person(name = "한석봉"))

    // 연습문제 2
    persons.forEach { person -> println(person.name) }

    // 연습문제 3
    val persons2 = mutableMapOf<Person, Int>()
    persons2[Person(name = "홍길동")] = 20
    persons2[Person(name = "한석봉")] = 25

    persons2.forEach { p -> println("${p.key.name}의 나이는 ${p.value}살") }

}
