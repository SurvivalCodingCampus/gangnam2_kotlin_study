package com.survivalcoding.kotlinstudy.`06_abstract_class_interface`

//abstract class Human {
//    abstract fun speak()
//}

// 인스턴스화 못함
interface Human {
    // val hp: Int  프로퍼티 -> 메서드로 변환이 됨 변수나 상수가 아님

    fun speak()
}

class Man : Human {
    override fun speak() {

    }
}
