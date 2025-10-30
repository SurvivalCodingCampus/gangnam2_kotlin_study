package com.survival.kotlinstudy.`02_instance_class`

fun main() {
    // 기본 생성자
    val hero = Hero()
    val hero2 = Hero(name = "홍길동", hp = 10)
    println("test")
}

class Hero (var name: String = "",var hp: Int = 0){
    // 멤버변수, field,
    // name
    // hp

    fun attack() {
        hp -= 10
    }

    fun run() {

    }

    fun sleep() {

    }
}
