package com.neouul.sesac.`03-collection`

fun main() {
    val person1 = Person("홍길동", 20)
    val person2 = Person("한석봉", 25)

    val personList = listOf<Person>(person1, person2)
    for (person in personList) {
        println(person.name)
    }

    val personMap = mapOf<String, Int>(
        person1.name to person1.age,
        person2.name to person2.age,
    )
    personMap.forEach {
        println("${it.key}의 나이는 ${it.value}살")
    }
}