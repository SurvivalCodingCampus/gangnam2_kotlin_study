package com.survival.kotlinstudy.`03_encapsulation`

class Student(
    val id: Int,
    val name: String,
    age: Int = 0,
) {
    private var _age = age
    var age: Int = 0
        get() = _age
        set(value) {
            // value 라고 쓰는거 관행?
            // value 는 밑에 _age = 100 ->100 데이터를나타냄
            // field 는 진짜 필드를 의미?
            field = value
        }

    fun study() {
        _age = 10
    }
}

fun main() {
    val student = Student(0, "홍길동")
    student.id
}