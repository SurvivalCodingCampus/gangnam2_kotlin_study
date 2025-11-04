package com.survivalcoding.kotlinstudy.`06_interface`

//abstract class Human {
//    abstract fun speak()
//}

// 인스턴스화 못 함
interface Human {
    val hp: Int

    fun speak()
}

//class Man : Human {
//    override fun speak() {
//        TODO("Not yet implemented")
//    }
//}

class Person {
    // 나중에 초기화. 금지 (왠만하면 안 쓴다)
    lateinit var name: String

    // 인스턴스화 되면서 초기화
    val age2 = 0

    // 나중에 초기화
    val age: Int by lazy {
        0
    }

    fun function() {
        name = "홍길동"
    }
}

fun main() {
    var person: Person? = Person()
    println(person?.name)

    person = null
}