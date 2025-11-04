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
