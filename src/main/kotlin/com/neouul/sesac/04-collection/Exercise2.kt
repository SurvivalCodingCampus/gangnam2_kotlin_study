package com.neouul.sesac.`04-collection`

fun main() {
    val person1 = Person("홍길동")
    val person2 = Person("한석봉")

    val personList = listOf<Person>(person1, person2)
    for (person in personList) {
        println(person.name)
    }
}