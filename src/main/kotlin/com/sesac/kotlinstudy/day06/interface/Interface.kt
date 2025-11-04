package com.sesac.kotlinstudy.day06.`interface`

//abstract class Human {
//    abstract fun speak()
//}

// 인스턴스화 못 함
interface Human {
//    val hp: Int

    fun speak()
}

class Man : Human {
    override fun speak() {

    }
}

class Person {
    // 나중에 초기화. 금지 (왠만하면 안 쓴다)
    lateinit var name: String

    // 나중에 초기화
    val age: Int by lazy {
        0
    }

    fun init() {
        name = "홍길동"
    }
}

fun main() {
    val person = Person()
//    println(person.name) // error
    println(person.age)
}
