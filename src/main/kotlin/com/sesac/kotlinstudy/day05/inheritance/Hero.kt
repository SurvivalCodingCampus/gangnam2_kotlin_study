package com.sesac.kotlinstudy.day05.inheritance

open class Hero(
    var name: String,
    var hp: Int = 50,
) {
    init {
        println("Hero의 init")
    }

    open fun run() {
        println("Hero의 run")
    }
}
