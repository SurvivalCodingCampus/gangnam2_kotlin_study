package com.survival.kotlinstudy.`04_collection`

class Person(
    val name: String,
) {
    var age: Int = 0
}

fun main() {
    // 연습문제 2
    val hong = Person(name = "홍길동")
    val han = Person(name = "한석봉")
    val list = listOf(hong, han)
    for (person in list) {
        println(person.name)
    }

    // 연습문제 3
    hong.age = 20
    han.age = 25

    val map = mapOf(hong.name to hong.age, han.name to han.age)

    for ((name, age) in map) {
        println("${name}의 나이는 ${age}살")
    }


}