package com.sesac.kotlinstudy.day04.encapsulation

class Student(
    var id: Int,
    val name: String,
    age: Int = 0,
) {
    private var _age = age
    var age: Int = 0
        get() = _age
        set(value) {
            field = value + 1
        }

    fun study() {
        age = 10
    }
}

fun main() {
    val student = Student(0, "홍길동")
    student.id = 100
//    student.name = ""
//    student.age = 100

    student.study()
    println(student.age)
}
