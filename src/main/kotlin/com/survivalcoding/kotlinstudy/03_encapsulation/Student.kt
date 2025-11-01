package com.survivalcoding.kotlinstudy.`03_encapsulation`

class Student(
    var id: Int,
    val name: String,
) {

    var age: Int = 0
        set(value) {
            field = value * 10
        }

    fun study() {
        require(true)
        age = 10
    }

}

fun main() {
    val student = Student(0, "홍길동")
    student.id = 100

    student.study()
    println(student.age)
}