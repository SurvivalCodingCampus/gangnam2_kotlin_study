package com.luca.kotlinstudy._03_encapsulation

class Student(
    var id: Int,
    val name: String,
    age: Int = 0,
) {  // get + set 만드는 방법 1
    private var _age = age
    var age: Int = 0
        //   get() = _age
        set(value) {
            field = value
        }

    fun study() {
        age = 10
    }
}

fun main() {
    val student = Student(0, "홍길동")
    student.id = 100; // 게터가 있다
}