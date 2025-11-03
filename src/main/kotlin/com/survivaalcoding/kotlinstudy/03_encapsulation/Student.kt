package com.survivaalcoding.kotlinstudy.`03_encapsulation`

class Student(val id: Int, val name: String) {
    val ban: Int = 1
}

fun main() {
    val student = Student(1, "a")
    print(student.ban)
}