package com.survival.kotlinstudy.`04_collection`

class Person(
    val name: String,
) {


}

fun main() {
    val hong = Person(name = "홍길동")
    val han = Person(name = "한석봉")
    val list = listOf(hong, han)
    for (person in list) {
        println(person.name)
    }
}