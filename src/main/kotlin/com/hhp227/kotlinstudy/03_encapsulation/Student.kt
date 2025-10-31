package com.hhp227.kotlinstudy.`03_encapsulation`

class Student(
    var id: Int,
    var name: String,
    age: Int = 0
) {
    private var _age = age

    var age: Int = 0
        set(value) {
            field = value
        }

    fun study() {
        age = 10
    }
}